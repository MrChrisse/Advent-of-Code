package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day7_better {
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        method("shiny gold");
        System.out.println(result.size());
    }

    public static void method(String a) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day7/input_day7.txt"));
        while (s.hasNextLine()) {
            String l = s.nextLine();
            if (l.contains(a) && !l.startsWith(a)) {
                String[] b = l.split(" ");
                String valid = b[0] + " " + b[1];
                if (!result.contains(valid)) {
                    result.add(valid);
                    method(valid);
                }
            }
        }
    }
}