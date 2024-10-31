package chapter6;

public class Anagram {
    public static void findAnagrams(String word, String rest) {
        if (word == null || word.length() == 0) {
            System.out.println("Anagram: " + rest);
        } else if (word.length() == 1) {
            System.out.println(rest + word);
        } else {
            String ith = "", remaining = "";
            for (int i = 0; i < word.length(); i++) {
                ith = word.charAt(i) + "";
                remaining = word.substring(0, i) + word.substring(i + 1, word.length());
                findAnagrams(remaining, rest + ith);
            }
        }   
    }

    public static void findAnagrams(String word) {
        findAnagrams(word, "");
    }

    public static void main(String[] args) {
        String input = "abc";
        findAnagrams(input);
    }
}