package MapInterface;
import java.util.*;


    public class MaxValueKeyFinder {
        public static String findMaxKey(Map<String, Integer> map) {
            if (map.isEmpty()) {
                return null; // Return null if map is empty
            }

            String maxKey = null;
            int maxValue = Integer.MIN_VALUE;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            return maxKey;
        }

        public static void main(String[] args) {
            // Example Input
            Map<String, Integer> sampleMap = new HashMap<>();
            sampleMap.put("A", 10);
            sampleMap.put("B", 20);
            sampleMap.put("C", 15);

            // Find and print the key with the highest value
            String maxKey = findMaxKey(sampleMap);
            System.out.println("Key with the highest value: " + maxKey);
        }
    }



