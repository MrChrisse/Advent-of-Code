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
        int line = 0;
        long sum = 0;
        while (true) {
            String mask = lines.get(line).replace("mask = ", "");
            System.out.println(mask);
            String[] result = new String[100000];
            line++;
            //Arrays.fill(result, "");

            while (lines.size() > line && lines.get(line).startsWith("mem")) {
                String[] line_arr = lines.get(line).split("]");
                int mem_addr = Integer.parseInt(line_arr[0].split("\\[")[1]);
                int val = Integer.parseInt(line_arr[1].replace(" = ", ""));
                String val_byte = Integer.toBinaryString(val);
                val_byte = padLeftZeros(val_byte, 36);
                System.out.println(val_byte);
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
                line++;

            }
            for (int i = 0; i < result.length; i++) {
                if (!Objects.equals(result[i], null)) {
                    System.out.println(result[i]);
                    long dec = Long.parseLong(result[i], 2);
                    sum = sum + dec;
                }
            }
            System.out.println(sum);

            if (lines.size() < line + 1) break;
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
