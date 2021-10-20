package com.deligkarisk;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    static Scanner inputScanner = new Scanner(System.in);
    private static Bank mainBank;


    public static void main(String[] args) {


        System.out.println("Welcome to the banking application.");

        mainBank = new Bank();

        int selection = 0;
        while (selection != -1) {
            System.out.println("Please make your selection below: ");
            int input = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (input) {
                case 1:
                    addBranchToBank();
                    break;
                case 2:
                    addCustomerToBranch();
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4:
                    showCustomers();
                    break;
                case 5:
                    selection = -1;
                    System.out.println("Exiting.");
                    break;

            }
        }
    }

   private static void addBranchToBank() {
       System.out.println("Enter branch name:");
       String branchName = inputScanner.nextLine();
       mainBank.addBranch(branchName);
   }

   private static void addCustomerToBranch() {

       System.out.println("Enter the branch name: ");
       String branchName = inputScanner.nextLine();

       System.out.println("Enter new customer's name:");
       String newCustomerName = inputScanner.nextLine();

       System.out.println("Enter initial transaction amount:");
       Double initialTransaction = inputScanner.nextDouble();
       inputScanner.nextLine();

       mainBank.addNewCustomerToBranch(newCustomerName, branchName, initialTransaction);
   }

   private static void addTransaction() {
       System.out.println("Enter the branch name: ");
       String branchName = inputScanner.nextLine();

       System.out.println("Enter customer's name:");
       String customerName = inputScanner.nextLine();

       System.out.println("Enter transaction amount:");
       double transaction = inputScanner.nextDouble();
       inputScanner.nextLine();

       mainBank.addTransaction(customerName, branchName,transaction );

   }

   public static void showCustomers() {
       System.out.println("Enter the branch name: ");
       String branchName = inputScanner.nextLine();

       mainBank.showCustomers(branchName, true);
   }
}
