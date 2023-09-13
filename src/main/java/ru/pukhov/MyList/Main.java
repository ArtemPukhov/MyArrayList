package ru.pukhov.MyList;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> myList = new MyArrayList<>();

        myList.add(5);
        myList.add(2);
        myList.add(8);
        myList.add(1);
        myList.add(9);

        for(int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + ", ");
        }
        System.out.println();


        myList.quickSort(Integer::compareTo);

        for(int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + ", ");
        }



    }
}