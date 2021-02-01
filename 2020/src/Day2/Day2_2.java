package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("Advent_Of_Code/2020/src/Day2/passwords_policy.txt"));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        int result = 0;

        for (String cur_line : lines) {
            String[] parts = cur_line.split("\\s+");
            String numbers = parts[0];
            String[] numbers_part = numbers.split("-");
            int num1 = Integer.parseInt(numbers_part[0]) - 1;
            int num2 = Integer.parseInt(numbers_part[1]) - 1;
            String character_part = parts[1];
            String character = character_part.substring(0, 1);
            String password = parts[2];
            String[] password_chars = password.split("");

            if (password_chars[num1].equals(character) ^ password_chars[num2].equals(character)) {
                result = result + 1;
            }
        }
        System.out.println(result);
    }
}