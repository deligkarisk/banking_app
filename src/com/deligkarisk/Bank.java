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

    public void addNewCustomerToBranch(Customer customer, Branch branch) {

        Optional<Customer> existingCustomer = branch.findCustomer(customer.getName());
        if (existingCustomer.isPresent()) {
            System.out.println("Customer already exists, nothing to add.");
            return;
        }

        branch.addCustomer(customer);
    }

    public void addTransaction(Customer customer, Branch branch, double transaction) {
        branch.addTransaction(customer, transaction);
    }


    public void showCustomers(Branch branch, boolean showTransactions) {
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
