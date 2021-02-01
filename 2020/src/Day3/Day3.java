package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    private static List<String> lines;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Advent_Of_Code/2020/src/Day3/tree_map.txt"));
        lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        int result = 0;
        int pos = 0;
        for (int i = 1; i < lines.size(); i++){
            if(pos > 27){
                pos = pos - 31;
            }
            pos = pos + 3;
            result = result + foundTree(i, pos);

        }
        System.out.println(result);
    }

    private static int foundTree(int line, int position){
        String currentLine = lines.get(line);
        if(Character.toString(currentLine.charAt(position)).equals("#")){
            return 1;
        }
        return 0;
    }
}
