/*
 * INSTRUCTION:
 *     This is a Java staring code for hw2_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/* Title: CST370-HW2_1_Java
 * Abstract: Program accepts an input of a list of integers, and outputs the minimum distance between any two integers,
 * with all integer pairs that have the minimum distance represented.
 * Name: Bryan Zanoli
 * Date: 09/08/2024
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main
{
    public static class Pairs {
        public int x;
        public int y;
        public int distance;

        public Pairs(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.abs(x - y);
        }
    }

    public static List<String> sort(List<String> values) {
        for (int i = 0; i < values.size()-1; i++) {
            for (int k = i+1; k < values.size(); k++) {
                if (i != k) {
                    int value1 = Integer.parseInt(values.get(i));
                    int value2 = Integer.parseInt(values.get(k));
                    if (value1 > value2) {
                        values.set(i, values.get(k));
                        values.set(k, Integer.toString(value1));
                    }
                }
            }
        }
        return values;
    }

    public static void main(String[] args) {

        List<String> values = new ArrayList<String>();

        List<Pairs> pairs = new ArrayList<Pairs>();
        int curDistance = 0;
        int minDistance = -1;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s1 = scanner.nextLine();
            if(!values.contains(s1)) {
                values.add(s1);
            }
        }
        scanner.close();

        values = sort(values);
        System.out.println("Sorted Values: " + values);
        for (int i = 0; i < values.size()-1; i++) {
            for (int k = i+1; k < values.size(); k++) {
                if (i != k) {
                    int value1 = Integer.parseInt(values.get(i));
                    int value2 = Integer.parseInt(values.get(k));
                    if (value1 != value2) {
                        curDistance = Math.abs(value1 - value2);
                        if (curDistance < minDistance || minDistance == -1) {
                            minDistance = curDistance;
                        }
                        if (value1 <= value2) {
                            pairs.add(new Pairs(value1, value2));
                            System.out.println("Pair: " + value1 + " " + value2 + ", Distance: " + curDistance);
                        }
                    }

                }
            }
        }

        System.out.println("Min Distance:" + minDistance);
        final int min = minDistance;
        pairs.forEach(pair -> {
            if (pair.distance == min) {
                System.out.println("Pair:" + pair.x + " " + pair.y);
            }
        });

        //System.out.println(pairs);
    }
}

