package com.string;

public class ReverseWords {

    public static String reverseWords(String input) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        // Loop through each character in the string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // If the character is not a space, add it to the current word
            if (currentChar != ' ') {
                word.append(currentChar);
            } else {
                // Reverse the current word and append it to the result
                for (int j = word.length() - 1; j >= 0; j--) {
                    result.append(word.charAt(j));
                }
                // Append the space after reversing the word
                result.append(' ');
                // Reset the word StringBuilder for the next word
                word.setLength(0);
            }
        }

        // For the last word (since there might be no trailing space)
        for (int j = word.length() - 1; j >= 0; j--) {
            result.append(word.charAt(j));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "   Hello    W orld from ChatGPT    ";
        String result = reverseWords(input);
        System.out.println(result);
    }
}

