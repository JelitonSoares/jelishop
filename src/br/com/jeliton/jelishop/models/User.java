package br.com.jeliton.jelishop.models;

public class User {

    private double credit;

    public User (double credit) {
        this.credit = credit;
    }

    public double getCredit () {
        return this.credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void printCredit () {
        System.out.println("""
                        ******************************
                                   Saldo: %.2f
                                   
                        ******************************
                        """.formatted(this.credit));
    }
}
