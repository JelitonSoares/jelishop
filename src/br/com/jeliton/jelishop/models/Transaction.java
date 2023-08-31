package br.com.jeliton.jelishop.models;

public class Transaction {

    private String name;
    private double price;

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

    @Override
    public String toString() {
        return "Produto: " + this.name + " Preço: " + this.price;
    }
}
