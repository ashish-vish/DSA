package com.recursion;

public class StringPllindromeofNot {
    public static void main(String[] args) {
        String str = "aa";
        boolean result = pallindrome(str,0,str.length()-1);
        System.out.println(result);
    }

    private static boolean pallindrome(String str,int st,int end) {
        if(st>=end)
            return true;
        if(str.charAt(st)!=str.charAt(end))
            return false;
        return pallindrome(str,st+1,end-1);

    }
}
