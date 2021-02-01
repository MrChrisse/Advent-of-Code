package Day21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day21 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day21/input_day21.txt"));
        ArrayList<String> lines = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
    }
}
