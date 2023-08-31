package br.com.jeliton.jelishop.models;


import java.util.List;

public class Transaction implements Comparable<Transaction> {
    private String name;
    private double price;

    public Transaction (String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
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
        return Double.compare(this.getPrice(), otherTransaction.getPrice());
    }

}
