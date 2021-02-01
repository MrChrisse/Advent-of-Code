package Day6;

import jdk.jshell.execution.Util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Day6_2 {

    public static void main(String[] args) throws FileNotFoundException {
        File fileObject = new File("Advent_Of_Code/2020/src/Day6/input_day6.txt");
        Scanner sc = new Scanner(fileObject);

        int[] answers = new int[26];
        String line="";
        boolean nowBreak = false;
        int part1answer=0;
        int part2answer=0;
        int peopleingroup=0;
        int answerCountPart1=0;
        int answerCountPart2=0;

        while (true) {
            if (!nowBreak) {
                line = sc.nextLine();
            }

            if (line.contentEquals("") || nowBreak) {
                for (int i=0;i<26;i++) {
                    if (answers[i]>0) {
                        answerCountPart1++;
                    }
                    if (answers[i]==peopleingroup) {
                        answerCountPart2++;
                        System.out.println("Answer: " + answers[i] + " peopleingroup: " + peopleingroup);
                    }
                }

                for (int i=0; i<26;i++) {
                    answers[i]=0;
                }

                part1answer=part1answer+answerCountPart1;
                part2answer=part2answer+answerCountPart2;
                if (nowBreak) {
                    break;
                }
                peopleingroup=0;
                answerCountPart1=0;
                answerCountPart2=0;
            }

            if (line.length()>0) {
                for (int i=0; i<line.length(); i++) {
                    answers[(int)line.charAt(i)-97]++;
                }
                peopleingroup++;
            }

            if (!sc.hasNext()) {
                nowBreak=true;
            }
        }

        sc.close();
        System.out.println("Part 1 answer: " + part1answer);
        System.out.println("Part 2 answer: " + part2answer);
    }
}