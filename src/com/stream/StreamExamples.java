package com.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {
        String sentence = "hello world java 8 features";
        IntStream chars = sentence.chars();
        Stream<Character> characterStream = chars.mapToObj(c -> (char) c);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,15,16,32,11,1,2,4);
        List<Integer> evenList = list.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
//        evenList.stream().forEach(System.out::println);

        List<String> numStartWithOne = list.stream()
                .map(num -> num.toString())
                .filter(c -> c.startsWith("1"))
                .collect(Collectors.toList());
//        System.out.println(numStartWithOne);

        Set<Integer> set = new HashSet<>();
        List<Integer> duplicateElements = list.stream()
                .filter(n -> !set.add(n))
                .collect(Collectors.toList());
//        System.out.println(duplicateElements);

//        System.out.println(list.stream().count());
        Integer maxElement = list.stream()
                .max(Integer::compare)
                .get();
//        System.out.println(maxElement);

        LinkedHashMap<Integer, Long> mapOfCountingOfEachElement = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
//        System.out.println(mapOfCountingOfEachElement);

        String str = "Jevr artijcles are Awesome";


        Character firstDuplicateCharecter = str.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .findFirst()
                .get();
//        System.out.println(firstDuplicateCharecter);

        String[] s = str.split(" ");
        List<String> collect = Arrays.stream(s)
                        .map(StreamExamples::convertFirstCharToUpperCase)
                                .collect(Collectors.toList());
        System.out.println(collect);
        List<String> listOfStingWithFirstCharUp = Arrays.stream(s)
                .map(s1 -> {
                    char[] charArray = s1.toCharArray();
                    charArray[0] = Character.toUpperCase(charArray[0]);
                    return Arrays.toString(charArray);
                })
                .collect(Collectors.toList());
        System.out.println(listOfStingWithFirstCharUp);

    }
    public static String convertFirstCharToUpperCase(String str){
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return Arrays.toString(charArray);
    }

}
