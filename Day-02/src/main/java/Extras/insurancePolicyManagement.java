package Extras;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



    class policy implements Comparable<policy> {
        String policyNumber;
        String policyholderName;
        LocalDate expiryDate;
        String coverageType;
        double premiumAmount;

        public policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            policy policy = (Extras.policy) obj;
            return Objects.equals(policyNumber, policy.policyNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(policyNumber);
        }

        @Override
        public int compareTo(policy other) {
            return this.expiryDate.compareTo(other.expiryDate);
        }

        @Override
        public String toString() {
            return String.format("Policy[%s, %s, %s, %s, $%.2f]", policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
        }
    }

    public class insurancePolicyManagement {
        private Set<policy> hashSetPolicies = new HashSet<>();
        private Set<policy> linkedHashSetPolicies = new LinkedHashSet<>();
        private Set<policy> treeSetPolicies = new TreeSet<>();

        // Add policy to all sets
        public void addPolicy(policy policy) {
            hashSetPolicies.add(policy);
            linkedHashSetPolicies.add(policy);
            treeSetPolicies.add(policy);
        }

        // Get all unique policies
        public Set<policy> getAllPolicies() {
            return new HashSet<>(hashSetPolicies);
        }

        // Get policies expiring in the next 30 days
        public Set<policy> getExpiringPolicies() {
            Set<policy> expiring = new TreeSet<>();
            LocalDate today = LocalDate.now();
            for (Extras.policy policy : treeSetPolicies) {
                if (ChronoUnit.DAYS.between(today, policy.expiryDate) <= 30) {
                    expiring.add(policy);
                }
            }
            return expiring;
        }

        // Get policies by coverage type
        public Set<policy> getPoliciesByCoverage(String coverageType) {
            Set<policy> filtered = new HashSet<>();
            for (Extras.policy policy : hashSetPolicies) {
                if (policy.coverageType.equalsIgnoreCase(coverageType)) {
                    filtered.add(policy);
                }
            }
            return filtered;
        }

        // Detect duplicate policies based on policy number
        public Set<policy> getDuplicatePolicies() {
            Set<String> seen = new HashSet<>();
            Set<policy> duplicates = new HashSet<>();
            for (Extras.policy policy : hashSetPolicies) {
                if (!seen.add(policy.policyNumber)) {
                    duplicates.add(policy);
                }
            }
            return duplicates;
        }

        // Performance Comparison
        public void comparePerformance() {
            int numPolicies = 100000;
            List<policy> policies = new ArrayList<>();
            for (int i = 0; i < numPolicies; i++) {
                policies.add(new policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i), "Health", 1000 + i));
            }

            long start, end;

            // HashSet Performance
            start = System.nanoTime();
            hashSetPolicies.addAll(policies);
            end = System.nanoTime();
            System.out.println("HashSet Add Time: " + (end - start) + " ns");

            start = System.nanoTime();
            hashSetPolicies.contains(new policy("P50000", "", LocalDate.MAX, "", 0));  // FIXED
            end = System.nanoTime();
            System.out.println("HashSet Search Time: " + (end - start) + " ns");

            // LinkedHashSet Performance
            start = System.nanoTime();
            linkedHashSetPolicies.addAll(policies);
            end = System.nanoTime();
            System.out.println("LinkedHashSet Add Time: " + (end - start) + " ns");

            start = System.nanoTime();
            linkedHashSetPolicies.contains(new policy("P50000", "", LocalDate.MAX, "", 0));  // FIXED
            end = System.nanoTime();
            System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

            // TreeSet Performance
            start = System.nanoTime();
            treeSetPolicies.addAll(policies);
            end = System.nanoTime();
            System.out.println("TreeSet Add Time: " + (end - start) + " ns");

            start = System.nanoTime();
            treeSetPolicies.contains(new policy("P50000", "", LocalDate.MAX, "", 0));  // FIXED
            end = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (end - start) + " ns");
        }


        public static void main(String[] args) {
            insurancePolicyManagement system = new insurancePolicyManagement();

            // Adding sample policies
            system.addPolicy(new policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
            system.addPolicy(new policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 700.0));
            system.addPolicy(new policy("P003", "Charlie", LocalDate.now().plusDays(20), "Home", 900.0));
            system.addPolicy(new policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0)); // Duplicate

            // Retrieve and display policies
            System.out.println("All Policies: " + system.getAllPolicies());
            System.out.println("Expiring Policies: " + system.getExpiringPolicies());
            System.out.println("Home Insurance Policies: " + system.getPoliciesByCoverage("Home"));
            System.out.println("Duplicate Policies: " + system.getDuplicatePolicies());

            // Compare performance
            system.comparePerformance();
        }
    }


