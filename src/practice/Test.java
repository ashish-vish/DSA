package practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String str = "capgeminibanglore";

        Set<Character> set = new HashSet<>();

        Character c1 = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !set.add(c))
                .findFirst()
                .get();
//        System.out.println(c1);

        String[] strArray = {"ravi","raju","venkat","rajesh"};

//        Map<String, Integer> res1 = Arrays.stream(strArray)
//                .filter(s -> s.startsWith("r"))
//                .collect(Collectors.toMap(Function.identity(), str1 -> str1.length()));
//        System.out.println(res1);

        String test = "batch698";
//        System.out.println(test.substring(5));

//        List<String> stringList = List.of("batch_234","batch_123","batch_678","batch_798");

//        String s1 = stringList.stream()
//                .map(s -> Integer.valueOf(s.substring(6)))
//                .max(Integer::compareTo)
//                .map(n -> "batch" + n)
//                .get();
//        System.out.println(s1);

        List<Integer> list = List.of(1,2,3,4,5,6,7,8);


        Iterator<Integer> itr = list.iterator();
        System.out.println(list);
        while (itr.hasNext()){
            if (itr.next() == 2)
                itr.remove();
        }
        System.out.println(list);
    }
}
