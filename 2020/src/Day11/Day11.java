package Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day11 {
    private static ArrayList<String> lines;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day11/input_day11.txt"));
        lines = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }

        while (true) {
            for (int i = 0; i < lines.size(); i++) {
                if(i != 0) {
                    StringBuilder line_before = new StringBuilder(lines.get(i - 1));
                }
                StringBuilder cur_line = new StringBuilder(lines.get(i));
                if(i != 96) {
                    StringBuilder line_after = new StringBuilder(lines.get(i + 1));
                }
                for (int j = 0; i < 92; i++) {
                    if (cur_line.charAt(j) == 'L'){
                        cur_line.setCharAt(j,'#');
                    }else if(cur_line.charAt(j) == '#'){
                        //int surrounding_seats = check_surroundings(i, j);
                    }
                }
            }

        }


    }

    /*private static void check_surroundings(int i, int j) {
        int surroundings = 0;
        String cur_line = lines.get(i);
        String line_before = "", line_after = "";
        if(i != 0){
            line_before = lines.get(i-1);
        }if(i != 96){
            line_after = lines.get(i+1);
        }
        if(line_before.charAt(j-1) == '#');
    }*/
}
