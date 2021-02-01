package Day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day20 {
    // ".": false; "#": true

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day20/input_day20.txt"));
        ArrayList<Tile> tiles = new ArrayList<>();
        while (s.hasNextLine()) {
            int cur_tile_number = 0;
            boolean[][] chars_temp = new boolean[10][10];
            String cur_line = s.nextLine();
            if (cur_line.contains("Tile")) {
                cur_tile_number = Integer.parseInt(cur_line.substring(5, 9));
                int j = 0;                    cur_line = s.nextLine();

                while (!cur_line.equals("")) {
                    if (!cur_line.contains("Tile")) {

                        for (int i = 0; i < 10; i++) {
                            if (cur_line.charAt(i) == '.')
                                chars_temp[j][i] = false;
                            else if (cur_line.charAt(i) == '#')
                                chars_temp[j][i] = true;
                            else
                                System.out.println("Error: Char not . or #");
                        }
                        j++;
                    }
                }
            }
            Tile tile_temp = new Tile(cur_tile_number, chars_temp);
            tiles.add(tile_temp);
        }
        System.out.println(tiles);

    }
}


class Tile {
    int tile_number;
    boolean[][] tile_items;


    public Tile(int tile_number, boolean[][] tile_items) {
        this.tile_number = tile_number;
        this.tile_items = tile_items;
    }
}
