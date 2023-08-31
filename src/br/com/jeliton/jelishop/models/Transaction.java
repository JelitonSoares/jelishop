package br.com.jeliton.jelishop.models;

import java.util.Comparator;
import java.util.List;

public class Transaction implements Comparable<Transaction> {

    User user;
    private String name;
    private double price;

    public Transaction (String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void extract (List<Transaction> list) {
        System.out.println("""
                        ******************************
                                               
                                  Compras                                  
                       """);
        this.printTransactionList(list);
        System.out.println("""
                                                                                                        
                        ******************************
                        """);
    }

    public void printTransactionList (List<Transaction> list) {
        list.forEach(System.out::println);
    }
    @Override
    public String toString() {
        return this.name + "---------------R$ %.2f".formatted(this.price);
    }

    @Override
    public int compareTo(Transaction otherTransaction) {
        if (this.getPrice() > otherTransaction.getPrice()) {
            return  1;
        } else if (this.getPrice() < otherTransaction.getPrice()) {
            return - 1;
        } else return 0;
    }

}
