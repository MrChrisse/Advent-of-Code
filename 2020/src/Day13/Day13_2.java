package Day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static java.util.stream.IntStream.range;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;


public class Day13_2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day13/input_day13.txt"));
        ArrayList<String> lines = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
        String[] s1 = lines.get(1).split(",");
        String[] busses_str = lines.get(1).split(",");
        ArrayList<Integer> busses = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();
        long[][] nums = range(0, s1.length).filter(i -> !s1[i].equals("x"))
                .mapToObj(i -> new long[]{parseLong(s1[i]), i})
                .toArray(long[][]::new);
        long product = stream(nums).mapToLong(a -> a[0]).reduce((a, b) -> a * b).getAsLong();
        long sum = stream(nums).mapToLong(a -> a[1] * (product/a[0]) * inverseModulo(product/a[0], a[0])).sum();
        System.out.println(product - sum % product);
    }

    static long inverseModulo(long x, long y){
        if(x!=0){
            long modulo = y % x;
            return modulo == 0 ? 1 : y - inverseModulo(modulo, x) * y / x;
        }
        return 0;
    }
}
