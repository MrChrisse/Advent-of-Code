package Day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day12 {

    private static int direction = 90;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day12/input_day12.txt"));
        ArrayList<String> lines = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
        int[] cur_position = new int[2];
        cur_position[0] = 0;
        cur_position[1] = 0;

        for (String line : lines) {
            switch (line.charAt(0)) {
                case 'N':
                    cur_position[1] = cur_position[1] + Integer.parseInt(line.substring(1));
                    break;
                case 'S':
                    cur_position[1] = cur_position[1] - Integer.parseInt(line.substring(1));
                    break;
                case 'E':
                    cur_position[0] = cur_position[0] + Integer.parseInt(line.substring(1));
                    break;
                case 'W':
                    cur_position[0] = cur_position[0] - Integer.parseInt(line.substring(1));
                    break;
                case 'L':
                    if ((direction - Integer.parseInt(line.substring(1))) > 0) {
                        direction = direction - Integer.parseInt(line.substring(1));
                    } else {
                        direction = direction - Integer.parseInt(line.substring(1)) + 360;
                    }
                    break;
                case 'R':
                    if ((direction + Integer.parseInt(line.substring(1))) < 361) {
                        direction = direction + Integer.parseInt(line.substring(1));
                    } else {
                        direction = direction + Integer.parseInt(line.substring(1)) - 360;
                    }
                    break;
                case 'F':
                    switch (direction) {
                        case 90:
                            cur_position[0] = cur_position[0] + Integer.parseInt(line.substring(1));
                            break;
                        case 180:
                            cur_position[1] = cur_position[1] - Integer.parseInt(line.substring(1));
                            break;
                        case 270:
                            cur_position[0] = cur_position[0] - Integer.parseInt(line.substring(1));
                            break;
                        case 360:
                            cur_position[1] = cur_position[1] + Integer.parseInt(line.substring(1));
                            break;
                        default:
                            System.out.println("Error");
                    }
            }
        }
        System.out.println(cur_position[0]);
        System.out.println(cur_position[1]);
        System.out.println(Math.abs(cur_position[0] + Math.abs(cur_position[1])));
    }
}
