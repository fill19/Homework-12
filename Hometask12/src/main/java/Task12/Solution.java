package Task12;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        TextReader WholeSong = new TextReader("WholeSong.txt", "BadWords.txt");

        int initAmountOfWords = WholeSong.getInitAmountOfWords();
        System.out.println("All words " + initAmountOfWords + "\n");

        List<String> wrongWords = Arrays.asList(WholeSong.getExcludedWords());
        int amountExcludedWords = WholeSong.getAmountOfNotValidWords();
        System.out.println("Wrong words: " + amountExcludedWords);
        wrongWords.forEach(System.out::println);


        int amount = new Scanner(System.in).nextInt();
        List<Object> topRepWords = WholeSong.getMostRepetitiveWords(amount);
        System.out.println("\n" + amount + " the most repetitive words: ");
        System.out.print(topRepWords);
    }
}
