package com.string;
/**
 * String only consists of digits and does not contain any leading zeros.
 * num = "35427" i.e, 35427 is largest
 */
public class LargestOddNumberInString {
    public static void main(String[] args) {
        String num = "1487";
        String result = "";
        int len = num.length();
        for (int i = len-1; i>=0; i--){
            int integer = num.charAt(i)-'0';
            if (integer%2 != 0){
                result = num.substring(0,i+1);
                break;
            }
        }
        System.out.println(result);
    }
}


/**
 *  2,2,1,3,4,4,5,0 7 ========== 8
 */
