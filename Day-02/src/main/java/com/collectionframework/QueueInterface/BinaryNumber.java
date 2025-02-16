package com.collectionframework.QueueInterface;
import java.util.*;
public class BinaryNumber {

        public static List<String> generateBinaryNumbers(int N) {
            List<String> result = new ArrayList<>();
            Queue<String> queue = new LinkedList<>();

            // Start with "1"
            queue.add("1");

            for (int i = 0; i < N; i++) {
                String current = queue.poll(); // Get the front element
                result.add(current); // Store in result

                // Generate next binary numbers
                queue.add(current + "0");
                queue.add(current + "1");
            }

            return result;
        }

        public static void main(String[] args) {
            int N = 5;  // Change this for different outputs
            List<String> binaryNumbers = generateBinaryNumbers(N);
            System.out.println(binaryNumbers);
        }
    }


