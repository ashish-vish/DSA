package com.string;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String str = "  he is     a ggoood man  ";
        char [] charArray = str.toCharArray();
        int start, end, current =0;
        int len = charArray.length;

        if (len ==1 ){
            System.out.println(str);
            return;
        }

        for (;current<len;current++){
            while (charArray[current] == ' '){
                current++;
                if (current >= len)
                    break;
            }
            if (current == len)
                break;
            start = current;
            while (charArray[current] != ' '){
                current++;
                if (current == len-1)
                    break;
            }
            end = current == len-1 ? current : current -1;
            reverseWord(charArray,start,end);
        }
        System.out.println(charArray);
    }
    static void reverseWord(char[] charArray, int start, int end){
        char temp;
        while (start < end){
            temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}
