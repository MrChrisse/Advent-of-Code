package Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day5_2 {
    private static List<String> lines;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Advent_Of_Code/2020/src/Day5/input_day5.txt"));
        lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        int result = 0;
        Boolean[] plane_array = new Boolean[999];
        Arrays.fill(plane_array, false);
        for(String array_line : lines){
            int[] rowColumn = getRowColumn(array_line);
            int SeatID = rowColumn[0] * 8 + rowColumn[1];
            plane_array[SeatID] = true;
        }
        for(int i = 0; i < plane_array.length; i++){
            if(!plane_array[i]){
                System.out.println(i);
            }
        }
    }

    private static int[] getRowColumn(String seat_encoded){
        int start = 0, end = 127, rows = 128, row, column;
        for(int i = 0; i < 7; i++){
            rows = rows / 2;
            char charAtPos = seat_encoded.charAt(i);
            if(charAtPos == 'B'){
                start = start + rows;
            }else if(charAtPos == 'F'){
                end = end - rows;
            }
        }
        row = start;
        end = 7;
        start = 0;
        rows = 8;

        for(int i = 7; i < 10; i++){
            rows = rows / 2;
            char charAtPos = seat_encoded.charAt(i);
            if(charAtPos == 'R'){
                start = start + rows;
            }else if(charAtPos == 'L'){
                end = end - rows;
            }
        }
        column = start;
        int[] rowColumn= new int[2];
        rowColumn[0] = row;
        rowColumn[1] = column;
        return rowColumn;
    }
}
