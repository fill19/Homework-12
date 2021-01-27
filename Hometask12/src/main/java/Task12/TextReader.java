package Task12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextReader {
    private List<String> countingOfWords;
    private List<String> badWords;
    private final List<String> checkingOfWords;
    private static final int sizeOfWord = 3;

    public TextReader(String textPath, String badWordsPath) throws IOException {

        countingOfWords = getcountingOfWords(textPath);
        badWords = getbadWords(badWordsPath);
        checkingOfWords = new ArrayList<>();
        checkingOfWords.addAll(countingOfWords);


    }

    private List<String> getcountingOfWords(String textPath) throws IOException {
        List<String> checklist = new ArrayList<>();
        String line = null;
        int count = 0;

        FileReader file = null;
        try {
            file = new FileReader(textPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(file);

        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            String words[] = line.split(" ");

            count = count + words.length;
        }

        System.out.println("Number of words present in given file: " + count);
        br.close();

        return checklist;
    }

    private List<String> getbadWords(String badWordsPath) throws IOException {
        try {
            return badWords = getcountingOfWords(badWordsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return badWords;
    }

    public final int getInitAmountOfWords() {
        return countingOfWords.size();
    }

    public final int getAmountOfNotValidWords() {
        return sizeOfWord;
    }

    public final List<String> getbadWords() {
        return badWords;
    }

    public String[] getExcludedWords() {
        List<String> wrongWords = new ArrayList<>();
        for (String word : countingOfWords) {
            if (word.length() < sizeOfWord || badWords.contains(word)) {
                wrongWords.add(word);

            }
        }

        checkingOfWords.removeAll(wrongWords);
        return wrongWords.toArray(new String[0]);

    }

    public final List<Object> getMostRepetitiveWords(final int n) {
        return Arrays.asList(
                checkingOfWords.stream().collect(
                        Collectors.groupingBy(words -> words, Collectors.counting()))
                        .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .limit(n).toArray());
    }
}


