package Extras;
import java.util.*;


    public class BankingSystem {
        private Map<String, Double> accounts = new HashMap<>(); // Stores accounts
        private TreeMap<Double, List<String>> sortedAccounts = new TreeMap<>(); // Sorts by balance
        private Queue<String> withdrawalQueue = new LinkedList<>(); // Processes withdrawals

        // Create a new account
        public void createAccount(String accountNumber, double initialBalance) {
            accounts.put(accountNumber, initialBalance);
            sortedAccounts.computeIfAbsent(initialBalance, k -> new ArrayList<>()).add(accountNumber);
        }

        // Deposit money
        public void deposit(String accountNumber, double amount) {
            if (!accounts.containsKey(accountNumber)) {
                System.out.println("Account not found!");
                return;
            }
            double oldBalance = accounts.get(accountNumber);
            double newBalance = oldBalance + amount;
            accounts.put(accountNumber, newBalance);

            // Update sortedAccounts
            sortedAccounts.get(oldBalance).remove(accountNumber);
            if (sortedAccounts.get(oldBalance).isEmpty()) sortedAccounts.remove(oldBalance);
            sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
        }

        // Request withdrawal (adds to queue)
        public void withdraw(String accountNumber, double amount) {
            if (!accounts.containsKey(accountNumber)) {
                System.out.println("Account not found!");
                return;
            }
            withdrawalQueue.add(accountNumber + "," + amount);
        }

        // Process pending withdrawals
        public void processWithdrawals() {
            while (!withdrawalQueue.isEmpty()) {
                String[] request = withdrawalQueue.poll().split(",");
                String accountNumber = request[0];
                double amount = Double.parseDouble(request[1]);

                if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
                    double oldBalance = accounts.get(accountNumber);
                    double newBalance = oldBalance - amount;
                    accounts.put(accountNumber, newBalance);

                    // Update sortedAccounts
                    sortedAccounts.get(oldBalance).remove(accountNumber);
                    if (sortedAccounts.get(oldBalance).isEmpty()) sortedAccounts.remove(oldBalance);
                    sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);

                    System.out.println("Withdrawal successful for " + accountNumber + ": $" + amount);
                } else {
                    System.out.println("Insufficient balance for " + accountNumber);
                }
            }
        }

        // Get accounts sorted by balance
        public Map<Double, List<String>> getSortedAccounts() {
            return sortedAccounts;
        }

        public static void main(String[] args) {
            BankingSystem bank = new BankingSystem();

            // Create accounts
            bank.createAccount("A100", 5000);
            bank.createAccount("A101", 3000);
            bank.createAccount("A102", 7000);

            // Deposit money
            bank.deposit("A101", 2000);

            // Request Withdrawals
            bank.withdraw("A100", 1000);
            bank.withdraw("A101", 6000); // Should fail due to insufficient funds

            // Process withdrawals
            bank.processWithdrawals();

            // Display sorted accounts by balance
            System.out.println("Accounts sorted by balance: " + bank.getSortedAccounts());
        }
    }


