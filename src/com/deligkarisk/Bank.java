package com.deligkarisk;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

public class Bank {

    ArrayList<Branch> branches = new ArrayList<>();


    public void addBranch(String branchName) {

        Optional<Branch> existingBranch = findBranch(branchName);
        if (existingBranch.isPresent()) {
            System.out.println("branch already exists, exiting...");
        }

        Branch branch = new Branch(branchName);
        branches.add(branch);
    }

    public boolean addNewCustomerToBranch(String customerName, String branchName, double initialAmount) {
        Optional<Branch> optionalBranch = findBranch(branchName);

        if (optionalBranch.isEmpty()) {
            return false;
        }

        Branch branch = optionalBranch.get();
        return branch.addCustomer(customerName, initialAmount);

    }

    public boolean addTransaction(String customerName, String branchName, double amount) {
        Optional<Branch> optionalBranch = findBranch(branchName);

        if (optionalBranch.isEmpty()) {
            return false;
        }

        Branch branch = optionalBranch.get();
        return branch.addTransaction(customerName, amount);
    }


    public void showCustomers(String branchName, boolean showTransactions) {
       Optional<Branch> optionalBranch = findBranch(branchName);

       if (optionalBranch.isEmpty()) {
           System.out.println("No such branch.");
           return;
       }

       Branch branch = optionalBranch.get();
       branch.showCustomers(showTransactions);
    }

    public Optional<Branch> findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getBranchName().equals(branchName)) {
                return Optional.of(branches.get(i));
            }
        }
        return Optional.empty();
    }





}
