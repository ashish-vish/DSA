package practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeMap {
    public static void main(String[] args) {
        int[] a = {3,4,1,2,1,2,3,2,3,2,3,4,2,3,4};

        TreeMap<Integer, Long> map = Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        () -> new TreeMap<>((o1,o2) -> o2-o1),
                        Collectors.counting()));

        System.out.println(map);
    }
}
