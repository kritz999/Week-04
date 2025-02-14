package com.exceptionhandling.banktransactionsystem;

import java.util.Scanner;

public class BankTransactionSystem {

    //custom exception
    static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }


        public static double withdraw(double amount, double balance) throws InsufficientBalanceException {
            if (amount > balance) {
                throw new InsufficientBalanceException("insufficient balance");
            }
            if (amount < 0) {
                throw new IllegalArgumentException("invalid amount");
            }
            balance -= amount;
            System.out.println("The balance is :" + balance);
            return balance;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("enter the balance in double size");
                double balance = sc.nextDouble();
                System.out.println("enter the wihdraw amount in double size");
                double amount = sc.nextDouble();
                balance = withdraw(amount, balance);

            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                sc.close();
            }
        }

    }
        }