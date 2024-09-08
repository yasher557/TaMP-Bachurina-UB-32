import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Вставьте текст: ");
        String text = in.nextLine();
        String[] sentences = text.split("\\.");
        for (int index = 0; index < sentences.length; index++) {
            System.out.println("В предложении " + (index + 1) + comparison(sentences[index]));
        }
    }

    public static String comparison(String sentence) {
        Sentence s = new Sentence(sentence);
        int count_vowels = s.count_vowels();
        int count_consonants = s.count_consonants();
        StringBuilder out = new StringBuilder();
        if (count_vowels > count_consonants) {out.append(" больше гласных чем согласных");}
        else {out.append(" больше согласных чем гласных");}
        out.append(" (гласных: ").append(count_vowels).append("; согласных: ").append(count_consonants).append(")");
        return out.toString();
    }
}

