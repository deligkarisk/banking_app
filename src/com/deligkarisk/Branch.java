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


    public boolean addCustomer(String newCustomerName, double initialTransaction) {
        Optional<Customer> potentialExistingCustomer = findCustomer(newCustomerName);
        if (potentialExistingCustomer.isPresent()) {
            return false;
        }

        Customer newCustomer = new Customer(newCustomerName, initialTransaction);
        customers.add(newCustomer);
        return true;
    }

    public boolean addTransaction(String customerName, double transactionAmount) {
        Optional<Customer> optionalCustomer = findCustomer(customerName);

        if (optionalCustomer.isEmpty()) {
            return false;
        }

        Customer existingCustomer = optionalCustomer.get();
        existingCustomer.addTransaction(transactionAmount);
        return true;
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
