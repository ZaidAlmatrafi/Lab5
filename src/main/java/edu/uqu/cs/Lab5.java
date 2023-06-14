package edu.uqu.cs;
/*

Lab 5 - File IO and Exceptions
CS 1312
*/
import java.util.*;
import java.io.*;
/*

Make sure to complete and submit your lab
*/
/* Remember to import required classes */

public class Lab5 {

    /************ Part 1 **************/

    // The method should read the file line by line and store each line in an array of Strings

    public static double computeAverageGrades(String file) {
        double sum = 0;
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                sum += Double.parseDouble(tokens[2]);
                count++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum / count;
    }
    /* Write your code here */

    /************ Part 2 **************/
    public static void findBestAndWorst(String inputFile, String outputFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            List<String[]> students = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                students.add(tokens);
            }
            br.close();
        
            // Sort based on score
            Collections.sort(students, (s1, s2) -> Double.compare(Double.parseDouble(s1[2]), Double.parseDouble(s2[2])));
        
            // Get best and worst
            String[] best = students.get(students.size() - 1);
            String[] worst = students.get(0);
        
            // Write to file
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            bw.write("Best," + best[1]);
            bw.newLine();
            bw.write("Worst," + worst[1]);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        /* You are not required to write any code here */

    }
}