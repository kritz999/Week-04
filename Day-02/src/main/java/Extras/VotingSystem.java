package Extras;
import java.util.*;

 public class VotingSystem {
        private Map<String, Integer> votesMap = new HashMap<>(); // Stores votes per candidate
        private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>(); // Maintains order
        private TreeMap<String, Integer> sortedResults = new TreeMap<>(); // Stores sorted results

        // Cast a vote for a candidate
        public void castVote(String candidate) {
            votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
            voteOrder.put(candidate, votesMap.get(candidate)); // Updates LinkedHashMap
            sortedResults.put(candidate, votesMap.get(candidate)); // Updates TreeMap
        }

        // Get sorted results using TreeMap
        public Map<String, Integer> getResultsSorted() {
            return sortedResults;
        }

        // Get results in the order votes were cast
        public Map<String, Integer> getResultsByVoteOrder() {
            return voteOrder;
        }

        public static void main(String[] args) {
            VotingSystem votingSystem = new VotingSystem();

            // Cast Votes
            votingSystem.castVote("Alice");
            votingSystem.castVote("Bob");
            votingSystem.castVote("Alice");
            votingSystem.castVote("Charlie");
            votingSystem.castVote("Bob");
            votingSystem.castVote("Bob");

            // Display Results
            System.out.println("Votes in order of voting: " + votingSystem.getResultsByVoteOrder());
            System.out.println("Votes sorted by candidate name: " + votingSystem.getResultsSorted());
        }
    }


