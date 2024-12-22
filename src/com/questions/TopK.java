package com.questions;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TopK {
    public static void main(String[] args) {
        String[] strArray = {"alex","aa","aaa","aaaaa","aaaa"};
        int k=3;
        Map<Integer,String> map = new TreeMap<>(Collections.reverseOrder());
        for (String str : strArray){
            int countVowel = countVowel(str);
            map.put(countVowel,str);
        }
        int counter=0;
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getValue());
            counter++;
            if (counter==k)
                return;
        }
    }

    private static int countVowel(String str) {
        str=str.toLowerCase();
        int count=0;
        for (int i=0;i<str.length();i++)
            if (str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u')
                count++;
        return count;
    }
}
