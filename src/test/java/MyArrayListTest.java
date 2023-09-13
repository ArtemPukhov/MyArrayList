import org.junit.Before;
import org.junit.Test;
import ru.pukhov.MyList.MyArrayList;

import static org.junit.Assert.*;

/**
 * Тесты для класса MyArrayList.
 */
public class MyArrayListTest {
    private MyArrayList<Integer> myList;

    /**
     * Выполняется перед каждым тестом для инициализации списка.
     */
    @Before
    public void setUp() {
        myList = new MyArrayList<>();
    }


    /**
     * Тест добавления элементов в список и их получения.
     */
    @Test
    public void testAddAndGet() {
        for (int i = 0; i < 1000; i++) {
            myList.add(i);
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals(Integer.valueOf(i), myList.get(i));
        }
    }

    /**
     * Тест добавления элемента по индексу.
     */
    @Test
    public void testAddByIndex() {
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        myList.add(1, 7); // Добавляем 7 по индексу 1
        assertEquals(Integer.valueOf(7), myList.get(1));
    }

    /**
     * Тест удаления элемента из списка.
     */
    @Test
    public void testRemove() {
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        for (int i = 0; i < 5; i++) {
            myList.remove(0);
        }

        assertEquals(5, myList.size());
    }

    /**
     * Тест очистки списка.
     */
    @Test
    public void testClear() {
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        myList.clear();
        assertEquals(0, myList.size());
        assertTrue(myList.isEmpty());
    }

    /**
     * Тест сортировки элементов списка.
     */
    @Test
    public void testSort() {
        for (int i = 9; i >= 0; i--) {
            myList.add(i);
        }

        myList.sort(Integer::compareTo);
        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i), myList.get(i));
        }
    }

    /**
     * Тест замены элемента в списке по индексу.
     */
    @Test
    public void testReplace() {
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        myList.replace(0, 7); // Заменяем элемент с индексом 0 на 7
        assertEquals(Integer.valueOf(7), myList.get(0));
    }

    /**
     * Тест сортировки элементов списка с использованием quickSort.
     */
    @Test
    public void testQuickSort() {
        for (int i = 9; i >= 0; i--) {
            myList.add(i);
        }

        myList.quickSort(Integer::compareTo);
        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i), myList.get(i));
        }
    }
}
