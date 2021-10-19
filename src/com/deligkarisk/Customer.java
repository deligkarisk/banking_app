package com.deligkarisk;

import java.util.ArrayList;

public class Customer {

    String name;

    ArrayList<Double> transactions = new ArrayList<>();


    public Customer(String name) {
        this.name = name;
    }

    public void addTransaction(double amount) {
        transactions.add(amount);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }


}
