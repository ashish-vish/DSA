package com.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RemoveFirstDuplicateStringFromList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("dfg");
        list.add("abc");
        list.add("efg");
        list.add("efg");
        list.add("zzz");
        list.add("abc");

        HashMap<String,Integer> countMap = new HashMap<>();
        for (String str : list){
            if (countMap.containsKey(str)){
                countMap.put(str,countMap.get(str)+1);
            }else {
                countMap.put(str,1);
            }
        }
        System.out.println(list);
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()){
            String str = itr.next();
            if (countMap.get(str) > 1){
                countMap.put(str,countMap.get(str)-1);
                itr.remove();
            }
        }
        System.out.println(list);
    }
}
