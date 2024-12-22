package com.demo.stream;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String s1 = "silent";
        String s2 = "listen";

        if (s1.length()!=s2.length())
        {
            System.out.println("No");
            return;
        }

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        int i=0;
        for (char c : charArray1){
            if (c!=charArray2[i++]){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
