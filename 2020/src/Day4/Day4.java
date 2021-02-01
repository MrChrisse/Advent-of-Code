package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {

    private static List<String> lines;
    private static List<String> lines_2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Advent_Of_Code/2020/src/Day4/passport_attributes.txt"));
        lines = new ArrayList<>();
        lines_2 = new ArrayList<>();
        String line;
        int result = 0;

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        line = "";
        for (String s : lines) {
            if (s.equals("")) {
                lines_2.add(line);
                line = "";
            }
            line = line + s;
        }
        bufferedReader.close();

        for (String element : lines_2) {
            if (element.contains("byr") && element.contains("iyr") && element.contains("eyr") && element.contains("hgt")
                    && element.contains("hcl") && element.contains("ecl") && element.contains("pid")) {
                result++;
            }
        }
        result++;
        System.out.println("Result: " + result);
    }
}
