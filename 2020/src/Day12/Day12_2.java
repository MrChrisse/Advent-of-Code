package Day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day12_2 {

    private static final int direction = 90;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day12/input_day12.txt"));
        ArrayList<String> lines = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
        int[] cur_position = new int[2];

        int[] waypoint_pos = new int[2];
        waypoint_pos[0] = 10;
        waypoint_pos[1] = 1;

        for (String line : lines) {
            switch (line.charAt(0)) {
                case 'N':
                    waypoint_pos[1] = waypoint_pos[1] + Integer.parseInt(line.substring(1));
                    break;
                case 'S':
                    waypoint_pos[1] = waypoint_pos[1] - Integer.parseInt(line.substring(1));
                    break;
                case 'E':
                    waypoint_pos[0] = waypoint_pos[0] + Integer.parseInt(line.substring(1));
                    break;
                case 'W':
                    waypoint_pos[0] = waypoint_pos[0] - Integer.parseInt(line.substring(1));
                    break;
                case 'L':
                    for (int i = 0; i < (Integer.parseInt(line.substring(1)) / 90); i++){
                        int oldxw = waypoint_pos[0];
                        waypoint_pos[0] = -waypoint_pos[1];
                        waypoint_pos[1] = oldxw;
                    }
                    break;
                case 'R':
                    for (int i = 0; i < (Integer.parseInt(line.substring(1)) / 90); i++) {
                        int oldxw = waypoint_pos[0];
                        waypoint_pos[0] = waypoint_pos[1];
                        waypoint_pos[1] = -oldxw;
                    }
                    break;
                case 'F':
                    for (int i = 0; i < Integer.parseInt(line.substring(1)); i++){
                        cur_position[0] = cur_position[0] + waypoint_pos[0];
                        cur_position[1] = cur_position[1] + waypoint_pos[1];
                    }
                    break;
            }
        }
        System.out.println(Math.abs(cur_position[0] + Math.abs(cur_position[1])));
    }
}
