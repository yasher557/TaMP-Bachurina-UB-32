import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
    static Stack<String> lines = new Stack<>();
    static String s_path = "C:\\Users\\yasher557\\Desktop\\backup\\Файлы\\учеба\\моё\\3 семестр" +
            "\\технологии и методы программирования\\практика\\practice3";

    public static void Get_strings_in() {
        String s_file_name = "strings_file_IN.txt";
        String s_path_in = s_path + "\\" + s_file_name;
        System.out.println("\n");

        try {
            FileReader fileReader = new FileReader(s_path_in);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.push(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }
    }

    public static void Put_strings_out () {
        String s_path_out = s_path + "\\stringss_file_OUT.txt";

        try {
            FileWriter fileWriter = new FileWriter(s_path_out);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int stack_length = lines.size();
            for (int i_line_index = 0; i_line_index <= stack_length - 1; i_line_index++) {
                bufferedWriter.write(lines.pop());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
        }
    }

    public static void main (String[]args){
        Get_strings_in();
        Put_strings_out();
    }
}
