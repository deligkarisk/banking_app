package com.deligkarisk;

import java.util.ArrayList;
import java.util.Optional;

public class Branch {


    String branchName;

    ArrayList<Customer> customers = new ArrayList<>();


    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }


    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    public void addCustomer(Customer newCustomer, double initialTransaction) {
        customers.add(newCustomer);
        int addedCustomerIndex = customers.indexOf(newCustomer);
        Customer addedCustomer = customers.get(addedCustomerIndex);
        addTransaction(addedCustomer, initialTransaction);
    }

    public void addTransaction(Customer existingCustomer, double transaction) {
        existingCustomer.addTransaction(transaction);
    }


    public Optional<Customer> findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return Optional.of(customers.get(i));
            }
        }
        return Optional.empty();
    }

    public void showCustomers(boolean withTransactions) {


        if (customers.size() == 0) {
            System.out.println("No customers present.");
        }


        if (withTransactions) {
            for (Customer customer : customers) {
                System.out.println(customer.getName() + " with transactions: " + customer.getTransactions().toString());
            }
        } else {
            for (Customer customer : customers) {
                System.out.println(customer.getName());
            }
        }


    }
}
