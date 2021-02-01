package Day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day9 {

    private static List<Long> lines;
    private static List<Integer> elements;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day9/input_day9.txt"));
        lines = new ArrayList<>();
        elements = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(Long.valueOf(s.nextLine()));
        }
        /*for(int i = 0; i < 25; i++){
            elements.add(lines.get(i));
        }*/
        System.out.println("Aufgabe 1");
        int current_pos = 25;
        while(checkSum(current_pos)){
            current_pos++;
        }
        System.out.println(lines.get(current_pos));

        System.out.println("Aufgabe 2");
        checkSum2(501);
    }

    public static boolean checkSum(int current_pos){
        long current_num = lines.get(current_pos);
        for(int i = current_pos - 25; i < current_pos; i++){
            for (int j = current_pos - 24; j < current_pos; j++){
                if(current_num == lines.get(i) + lines.get(j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void checkSum2(int current_pos){
        long current_num = lines.get(current_pos);
        int i;
        int k = 0;
        outer:
        for(i = 0; i < current_pos; i++){
            long sum = lines.get(i);
            k = i + 1;
            while(true){
                if(sum != lines.get(current_pos)){
                    sum += lines.get(k);
                    k++;
                }
                if (sum == lines.get(current_pos)) {
                    System.out.println(lines.get(i) + lines.get(k));
                    break outer;
                }
                if (sum > lines.get(current_pos)) {
                    continue outer;
                }
            }
        }
        List<Long> subList = lines.subList(i, k);
        long max = subList.stream().mapToLong(a -> a).max().getAsLong();
        long min = subList.stream().mapToLong(a -> a).min().getAsLong();
        System.out.println(max + min);

    }
}
