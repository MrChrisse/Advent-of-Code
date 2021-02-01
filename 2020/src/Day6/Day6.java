package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Advent_Of_Code/2020/src/Day6/input_day6.txt"));
        List<String> lines = new ArrayList<>();
        String line;
        String buffer_str = "";
        while ((line = bufferedReader.readLine()) != null) {
            if(line.equals("")){
                lines.add(buffer_str);
                buffer_str = "";
            }
            buffer_str = buffer_str + line;
        }
        lines.add(buffer_str);
        bufferedReader.close();
        int result = 0;
        System.out.println(lines);

        List<String> lines_distinct = new ArrayList<>();
        for(String line_lines : lines){
            lines_distinct.add(Arrays.stream(line_lines.split("")).sorted()
                    .distinct().collect(Collectors.joining()));
        }
        System.out.println(lines_distinct);

        for(String element : lines_distinct){
            result = result + element.length();
            System.out.println(element.length());
        }
        System.out.println(result);

        }

}
