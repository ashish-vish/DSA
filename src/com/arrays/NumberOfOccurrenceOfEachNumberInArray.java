package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberOfOccurrenceOfEachNumberInArray {
    public static void main(String[] args) {
        int[] a = {2,5,4,1,7,8,7,3,4,5,6,7,1};

        Map<Integer, Long> collect = Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        Map<Integer, Integer> collect2 = new HashMap<>();

        for (int i=0;i<a.length;i++){
//            if (collect2.containsKey(a[i])){
//                collect2.put(a[i],collect2.get(a[i])+1);
//            }else{
//                collect2.put(a[i],1);
//            }
            collect2.put(a[i],collect2.getOrDefault(a[i],0)+1);
        }

        System.out.println(collect2);

    }
}
