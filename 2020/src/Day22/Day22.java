package Day22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day22 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("Advent_Of_Code/2020/src/Day22/input_day22.txt"));
        ArrayList<String> lines = new ArrayList<>();
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
        ArrayList<Integer> player1_deck = new ArrayList<Integer>();
        ArrayList<Integer> player2_deck = new ArrayList<Integer>();
        Collections.addAll(player1_deck, 28, 50, 9, 11, 4, 45, 19, 26, 42, 43, 31, 46, 21, 40, 33, 20, 7, 6, 17, 44, 5, 39, 35, 27, 10);
        Collections.addAll(player2_deck, 18, 16, 29, 41, 14, 12, 30, 37, 36, 24, 48, 38, 47, 34, 15, 8, 49, 23, 1, 3, 32, 25, 22, 13, 2);

        while(!player1_deck.isEmpty() && !player2_deck.isEmpty()){
            if(player1_deck.get(0) > player2_deck.get(0)){
                player1_deck.add(player1_deck.get(0));
                player1_deck.add(player2_deck.get(0));
                player1_deck.remove(0);
                player2_deck.remove(0);
            }else {
                player2_deck.add(player2_deck.get(0));
                player2_deck.add(player1_deck.get(0));
                player2_deck.remove(0);
                player1_deck.remove(0);
            }
        }
        int result = 0;
        int i = 1;
        if(player1_deck.isEmpty()){
            System.out.println("P2 " + player2_deck);
            for(int k = 49; k >= 0; k--){
                result = result + player2_deck.get(k) * i;
                i++;
            }
        }
        else if(player2_deck.isEmpty()){
            System.out.println("P1 " + player1_deck);
            for(int k = 49; k >= 0; k--){
                result = result + player1_deck.get(k) * i;
                i++;
            }
        }
        System.out.println(result);
    }
}