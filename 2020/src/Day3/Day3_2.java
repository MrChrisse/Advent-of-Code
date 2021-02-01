package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3_2 {

    private static List<String> lines;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Advent_Of_Code/2020/src/Day3/tree_map.txt"));
        lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        long result = 0;
        int pos = 0;
        for (int i = 1; i < lines.size(); i++){
            if(pos > 27){
                pos = pos - 31;
            }
            pos = pos + 3;
            result = result + foundTree(i, pos);
        }
        int result1 = goThroughMap(3, 1);
        int result2 = goThroughMap(1,1);
        int result3 = goThroughMap(5,1);
        int result4 = goThroughMap(7,1);
        int result5 = goThroughMap(1,2);
        result = (long) result1 * result2;
        result = result * result3;
        result = result * result4;
        result = result * result5;
        System.out.println(result);

    }

    private static int goThroughMap(int right, int down){
        int result = 0;
        int pos = 0;
        for (int i = down; i < lines.size(); i += down){
            if(pos > 30 - right){
                pos = pos - 31;
            }
            pos = pos + right;
            result = result + foundTree(i, pos);
        }
        return result;
    }

    private static int foundTree(int line, int position){
        String currentLine = lines.get(line);
        if(Character.toString(currentLine.charAt(position)).equals("#")){
            return 1;
        }
        return 0;
    }
}