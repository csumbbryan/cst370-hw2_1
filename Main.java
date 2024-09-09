/*
 * INSTRUCTION:
 *     This is a Java staring code for hw2_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Abstract: Describe the main ideas of the program.
 * Name: Write your name
 * Date: MM/DD/YYYY
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

    public static List<String> removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < list.size(); k++) {
                int value1 = Integer.parseInt(list.get(i));
                int value2 = Integer.parseInt(list.get(k));
                if (value1 == value2) {
                    list.remove(k);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> values = removeDuplicates(new ArrayList<String>());
        System.out.println("Values: " + values);
        List<Pairs> pairs = new ArrayList<Pairs>();
        int curDistance = 0;
        int minDistance = -1;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s1 = scanner.nextLine();
            values.add(s1);
        }

        for (int i = 0; i < values.size(); i++) {
            for (int k = 0; k < values.size(); k++) {
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

        System.out.println("Minimum Distance: " + minDistance);

        final int min = minDistance;

        pairs.forEach(pair -> {
            if (pair.distance == min) {
                System.out.println("Closest Pair: " + pair.x + " " + pair.y + ", Distance: " + pair.distance);
            }
        });

        //System.out.println(pairs);
    }
}

