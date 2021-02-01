package Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day10 {

    private static ArrayList<Integer> lines;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day10/input_day10.txt"));
        lines = new ArrayList<>();
        lines.add(0);
        while (s.hasNextLine()) {
            lines.add(Integer.valueOf(s.nextLine()));
        }
        Collections.sort(lines);
        int one = 0, three = 0;
        for(int i = 0; i < lines.size() - 1; i++){
            if(lines.get(i + 1) - lines.get(i) == 1){
                one++;
            }else if(lines.get(i + 1) - lines.get(i) == 3){
                three++;
            }
        }
        three++;
        System.out.println(one*three);

        int variants = 0;
        for(int i = 0; i < lines.size() - 2; i++){
            if(lines.get(i + 2) - lines.get(i) == 2){
                variants++;
            }
        }
        variants = variants - 1;
        System.out.println("Häufigkeit: " + variants);

        long[] dp = new long[lines.size()];
        Arrays.fill(dp, -1);
        System.out.println(count_ways(lines, 0, dp));

    }

    public static long count_ways(ArrayList<Integer> sequence, int index, long[] dp) {
        if (index == sequence.size() - 1) {
            return 1;
        }

        if (dp[index] != -1) {
            return dp[index];
        } else {
            long count = 0;
            for (int i = index + 1; i <= Math.min(index + 3, sequence.size() - 1); i++) {
                if (sequence.get(index) + 3 >= sequence.get(i)) {
                    count += count_ways(sequence, i, dp);
                }
            }
            dp[index] = count;
            return count;
        }
    }
}