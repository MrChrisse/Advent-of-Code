package Day7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day7 {
    private static List<String> lines;
    static String[][] all_bags = new String[594][2];
    static int result;


    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day7/input_day7.txt"));
        lines = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
        searchForBag("shiny gold");
        System.out.println(result);
    }

    public static void searchForBag(String bag){
        for (String current_str : lines) {
            if (current_str.contains(bag) && !current_str.startsWith(bag)) {
                String[] b = current_str.split(" ");
                String new_bag = b[0] + " " + b[1];
                result++;
                System.out.println(result);
                searchForBag(new_bag);
            }
        }
    }
}
