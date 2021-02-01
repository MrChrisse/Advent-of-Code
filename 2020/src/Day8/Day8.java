package Day8;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day8 {

    private static List<String> lines;
    private static List<Integer> lines_checked;
    static int accumulator;
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day8/input_day8.txt"));
        lines = new ArrayList<>();
        lines_checked = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
        goToLine(0);
        System.out.println("Result: " + accumulator);
    }
    
    public static void goToLine(int line) {
        String currentLine = lines.get(line);
        if (!lines_checked.contains(line)) {
            switch (currentLine.charAt(0)) {
                case 'j':
                    lines_checked.add(line);
                    if (currentLine.contains("+")) {
                        line = line + Integer.parseInt(currentLine.substring(5));
                    } else if (currentLine.contains("-")) {
                        line = line - Integer.parseInt(currentLine.substring(5));
                    }
                    goToLine(line);
                    break;
                case 'n':
                    lines_checked.add(line);
                    goToLine(line + 1);
                    break;
                case 'a':
                    lines_checked.add(line);
                    if (currentLine.contains("+")) {
                        accumulator = accumulator + Integer.parseInt(currentLine.substring(5));
                    } else if (currentLine.contains("-")) {
                        accumulator = accumulator - Integer.parseInt(currentLine.substring(5));
                    }
                    goToLine(line + 1);
                    break;
            }
        }else{
            System.out.println(line);
        }
    }
}
