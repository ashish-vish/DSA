package com.stream;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        List<Integer> naturalSortedList = list.stream()
                .sorted()
                .toList();
        List<Integer> reverseList = list.stream()
                .sorted()
                .toList();
        System.out.println(naturalSortedList);
        System.out.println(reverseList);

        int arr[] = { 99, 55, 203, 99, 4, 91 };
        List<Integer> list1 = Arrays.stream(arr)
                .boxed()
                .toList();


    }
}
