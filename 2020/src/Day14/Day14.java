package Day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Day14 {

    private static ArrayList<String> lines;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("2020/src/Day14/input_day14.txt"));
        lines = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
        int line_no = 0;
        long sum = 0;
        while (true) {
            String mask = "";
            if (lines.get(line_no).startsWith("mask")) {
                mask = lines.get(line_no).replace("mask = ", "");
            } else {
                System.out.println(lines.get(line_no));
            }
            line_no++;
            String[] result = new String[100000];
            //Arrays.fill(result, "");

            while (lines.size() > line_no && lines.get(line_no).startsWith("mem")) {
                String[] line_arr = lines.get(line_no).split("]");
                int mem_addr = Integer.parseInt(line_arr[0].split("\\[")[1]);
                int val = Integer.parseInt(line_arr[1].replace(" = ", ""));
                String val_byte = Integer.toBinaryString(val);
                val_byte = padLeftZeros(val_byte, 36);
                result[mem_addr] = "";
                for (int pos = 0; pos < mask.length(); pos++) {
                    if (mask.charAt(pos) == '0') {
                        result[mem_addr] = result[mem_addr] + "0";
                    }
                    if (mask.charAt(pos) == '1') {
                        result[mem_addr] = result[mem_addr] + "1";
                    }
                    if (mask.charAt(pos) == 'X') {
                        result[mem_addr] = result[mem_addr] + val_byte.charAt(pos);
                    }
                }
                line_no++;

            }
            for (int i = 0; i < result.length; i++) {
                if (!Objects.equals(result[i], null)) {
                    long dec = Long.parseLong(result[i], 2);
                    sum = sum + dec;
                }
            }
            System.out.println(sum);

            if (lines.size() < line_no + 1) break;
        }
        System.out.println(sum);
    }

    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);
        return sb.toString();
    }
}
