package Day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day13 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day13/input_day13.txt"));
        ArrayList<String> lines = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
        int timestamp = Integer.parseInt(lines.get(0));
        String[] busses_str = lines.get(1).split(",");
        ArrayList<Integer> busses = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();
        for(String bus : busses_str){
            if(!bus.equals("x")){
                busses.add(Integer.parseInt(bus));
            }
        }
        for(int bus : busses){
            int multiplier = timestamp / bus + 1;
            results.add(bus * multiplier);
            System.out.println("Zahl: " + bus + " Result: " + (bus * multiplier - timestamp));
        }
    }
}
