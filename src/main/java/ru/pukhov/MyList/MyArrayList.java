package ru.pukhov.MyList;

import java.util.Comparator;

/**
 * Реализация собственного ArrayList.
 *
 * @param <E> тип элементов, хранящихся в списке.
 */
public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;



    /**
     * Конструктор по умолчанию создает список с начальной емкостью 10.
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Конструктор с заданной начальной емкостью.
     *
     * @param initialCapacity начальная емкость списка.
     * @throws IllegalArgumentException если начальная емкость отрицательна.
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Начальная емкость не может быть отрицательной.");
        }
        elements = new Object[initialCapacity];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления.
     */
    public void add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index   индекс, по которому нужно добавить элемент.
     * @param element элемент для добавления.
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы");
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Получает элемент по указанному индексу.
     *
     * @param index индекс элемента.
     * @return элемент списка.
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы");
        }
        return (E) elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента для удаления.
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    /**
     * Очищает список, удаляя все элементы.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }


    /**
     * Сортирует элементы списка с использованием указанного компаратора.
     *
     * @param comparator компаратор для сортировки.
     */
    public void sort(Comparator<? super E> comparator) {
        if (size <= 1) {
            return;
        }

        quickSort(comparator);
    }

    /**
     * Заменяет элемент в списке по указанному индексу.
     *
     * @param index   индекс элемента для замены.
     * @param element новый элемент для замены.
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка.
     */
    public void replace(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы");
        }
        elements[index] = element;
    }

    /**
     * Возвращает текущий размер списка.
     *
     * @return размер списка.
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуст ли список.
     *
     * @return true, если список пуст, в противном случае - false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }


    /**
     * Сортирует элементы списка с использованием алгоритма quicksort.
     *
     * @param comparator компаратор для сортировки.
     */
    public void quickSort(Comparator<? super E> comparator) {
        quickSortRecursive(0, size - 1, comparator);
    }

    private void quickSortRecursive(int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quickSortRecursive(low, pivotIndex - 1, comparator);
            quickSortRecursive(pivotIndex + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<? super E> comparator) {
        E pivot = get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        E temp = get(i);
        replace(i, get(j));
        replace(j, temp);
    }
}
