package Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("2020/src/Day1/numbers.txt"));
        List<String> lines = new ArrayList<>();
        String line;
        while((line =bufferedReader.readLine()) != null){
            lines.add(line);
        }
        bufferedReader.close();
        int result = 0;

        System.out.println(lines.size());

        for(int i = 0; i < lines.size(); i++){
            for(int j = 0; j < lines.size(); j++){
                for (String s : lines) {
                    int firstNum = Integer.parseInt(lines.get(i));
                    int secondNum = Integer.parseInt(lines.get(j));
                    int thirdNum = Integer.parseInt(s);

                    if (firstNum + secondNum == 2020) {
                        result = firstNum * secondNum;
                        System.out.println("First num: " + firstNum);
                        System.out.println("Second num: " + secondNum);
                        System.out.println("Result: " + result);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
