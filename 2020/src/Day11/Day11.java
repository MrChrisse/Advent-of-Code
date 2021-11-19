package Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day11 {
    private static char[][] seats;
    private static int rows = 97;
    private static int cols = 91;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("2020/src/Day11/input_day11.txt"));
        seats = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (s.hasNextLine()) {
                String line = s.nextLine();
                for (int j = 0; j < cols; j++) {
                    seats[i][j] = line.charAt(j);
                }
            }
        }
        part2();
    }

    private static void part1() {
        int rounds = 0;

        while (rounds < 500) {
            char[][] seats_old = Arrays.stream(seats).map(char[]::clone).toArray(char[][]::new);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (seats_old[i][j] == 'L') {
                        int surrounding_seats = check_surroundings(i, j, seats_old);
                        if (surrounding_seats == 0) {
                            seats[i][j] = '#';
                        }
                    } else if (seats_old[i][j] == '#') {
                        int surrounding_seats = check_surroundings(i, j, seats_old);
                        if (surrounding_seats > 3) {
                            seats[i][j] = 'L';
                        }
                    }
                }
            }
            rounds++;
        }

        int final_occupied = countOccupied();

        System.out.println("Part 1:");
        System.out.println("Result " + final_occupied + " after Round " + rounds);
    }

    private static void part2() {
        int rounds = 0;

        while (rounds < 200) {
            char[][] seats_old = Arrays.stream(seats).map(char[]::clone).toArray(char[][]::new);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int surrounding_seats = check_Allsurroundings(i, j, seats_old);
                    if (seats_old[i][j] == 'L') {
                        if (surrounding_seats == 0) {
                            seats[i][j] = '#';
                        }
                    } else if (seats_old[i][j] == '#') {
                        if (surrounding_seats > 4) {
                            seats[i][j] = 'L';
                        }
                    }
                }
            }
            System.out.println("----------------------------------------------------------");
            System.out.println("Round " + rounds);
            System.out.println(Arrays.deepToString(seats).replace("], ", "]\n"));

            rounds++;

        }

        System.out.println(Arrays.deepToString(seats).replace("], ", "]\n"));

        int final_occupied = countOccupied();

        System.out.println("Part 2:");
        System.out.println("Result " + final_occupied + " after Round " + rounds);
    }

    private static int countOccupied() {
        int final_occupied = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seats[i][j] == '#') {
                    final_occupied++;
                }
            }
        }
        return final_occupied;
    }

    private static int check_surroundings(int i, int j, char[][] seats_old) {
        int occupied = 0;
        if (i > 0) {
            for (int temp_j = j - 1; temp_j < j + 2; temp_j++) {
                try {
                    if (seats_old[i - 1][temp_j] == '#') {
                        occupied++;
                    }
                } catch (Exception e) {
                }
            }
        }
        try {
            if (seats_old[i][j + 1] == '#') {
                occupied++;
            }
        } catch (Exception e) {
        }
        try {
            if (seats_old[i][j - 1] == '#') {
                occupied++;
            }
        } catch (Exception e) {
        }
        if (j < cols) {
            for (int temp_j = j - 1; temp_j < j + 2; temp_j++) {
                try {
                    if (seats_old[i + 1][temp_j] == '#') {
                        occupied++;
                    }
                } catch (Exception e) {
                }
            }
        }
        return occupied;
    }

    private static int check_Allsurroundings(int i, int j, char[][] seats_old) {
        int occupied = 0;
        //left
        for (int temp_j = j - 1; temp_j >= 0; temp_j--) {
            if (seats_old[i][temp_j] == '#') {
                occupied++;
                break;
            }
            if (seats_old[i][temp_j] == 'L') {
                break;
            }
        }
        //right
        for (int temp_j = j + 1; temp_j < cols; temp_j++) {
            if (seats_old[i][temp_j] == '#') {
                occupied++;
                break;
            }
            if (seats_old[i][temp_j] == 'L') {
                break;
            }
        }

        //top
        for (int temp_i = i - 1; temp_i >= 0; temp_i--) {
            if (seats_old[temp_i][j] == '#') {
                occupied++;
                break;
            }
            if (seats_old[temp_i][j] == 'L') {
                break;
            }
        }

        //bottom
        for (int temp_i = i + 1; temp_i < rows; temp_i++) {
            if (seats_old[temp_i][j] == '#') {
                occupied++;
                break;
            }
            if (seats_old[temp_i][j] == 'L') {
                break;
            }
        }

        //leftbottom
        int temp_j = j;
        for (int temp_i = i + 1; temp_i < rows; temp_i++) {
            temp_j--;
            if (temp_j < 0) break;
            if (seats_old[temp_i][temp_j] == '#') {
                occupied++;
                break;
            }
            if (seats_old[temp_i][temp_j] == 'L') {
                break;
            }
        }
        //lefttop
        temp_j = j;
        for (int temp_i = i - 1; temp_i >= 0; temp_i--) {
            temp_j--;
            if (temp_j < 0) break;
            if (seats_old[temp_i][temp_j] == '#') {
                occupied++;
                break;
            }
            if (seats_old[temp_i][temp_j] == 'L') {
                break;
            }
        }

        //righttop
        temp_j = j;
        for (int temp_i = i - 1; temp_i >= 0; temp_i--) {
            temp_j++;
            if (temp_j >= cols) break;
            if (seats_old[temp_i][temp_j] == '#') {
                occupied++;
                break;
            }
            if (seats_old[temp_i][temp_j] == 'L') {
                break;
            }
        }

        //rightbottom
        temp_j = j;
        for (int temp_i = i + 1; temp_i < rows; temp_i++) {
            temp_j++;
            if (temp_j >= cols) break;
            if (seats_old[temp_i][temp_j] == '#') {
                occupied++;
                break;
            }
            if (seats_old[temp_i][temp_j] == 'L') {
                break;
            }
        }
        return occupied;
    }
}