package Day8;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day8_2 {

    private static List<String> lines;
    private static List<String> lines_clone;
    private static List<Integer> lines_checked;
    static int accumulator;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day8/input_day8.txt"));
        lines = new ArrayList<>();
        lines_checked = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }

        for (int i = 0; i < lines.size(); i++){
            s = new Scanner(new File("Advent_Of_Code/2020/src/Day8/input_day8.txt"));
            lines_clone = new ArrayList<>();
            accumulator = 0;

            lines_checked = new ArrayList<>();
            while (s.hasNextLine()) {
                lines_clone.add(s.nextLine());
            }
            if(lines_clone.get(i).contains("jmp")){
                lines_clone.set(i, lines_clone.get(i).replace("jmp", "nop"));
                goToLine(0);
            }else if(lines_clone.get(i).contains("nop")){
                lines_clone.set(i, lines_clone.get(i).replace("nop", "jmp"));
                goToLine(0);
            }
        }
    }

    public static void goToLine(int line) {
        try {
            String currentLine = lines_clone.get(line);
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
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("ACC Terminated Value: " + accumulator + "           Line: " + line);
        }
    }

}
