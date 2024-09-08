import java.util.ArrayList;
import java.util.Arrays;

public class Sentence {
    private final ArrayList<Character> vowels;
    private final ArrayList<Character> consonants;
    private final char[] chars;
    public Sentence(String sentence) {
        chars = sentence.toLowerCase().toCharArray();
        vowels = new ArrayList<>(vowels_ru);
        vowels.addAll(vowels_en);
        consonants = new ArrayList<>(consonants_ru);
        consonants.addAll(consonants_en);
    }
    ArrayList<Character> vowels_ru = new ArrayList<>(Arrays.asList('а', 'о', 'у', 'э', 'ы', 'и', 'е', 'я', 'ё', 'ю'));
    ArrayList<Character> consonants_ru = new ArrayList<>(Arrays.asList(
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н',
            'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'));
    ArrayList<Character> vowels_en = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
    ArrayList<Character> consonants_en = new ArrayList<>(Arrays.asList(
            'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
            'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'));

    private int count(ArrayList<Character> list) {
        int count = 0;
        for (char character : chars) {
            if (list.contains(character)) {count++;}
        }
        return count;
    }
    public int count_vowels() {
        return count(vowels);
    }

    public int count_consonants() {
        return count(consonants);
    }
}

