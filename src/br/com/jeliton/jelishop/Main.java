package br.com.jeliton.jelishop;

import br.com.jeliton.jelishop.models.Transaction;
import br.com.jeliton.jelishop.models.User;

import java.util.*;

public class Main {
    public static void main (String[] args){

        boolean exit = false;

        Scanner scanner = new Scanner(System.in);
        List<Transaction> transactionList = new ArrayList<>();

        System.out.println("BEM VINDO AO JELISHOP!! ");
        System.out.println("LIMITE DE CRÉDITO: ");
        User user = new User(scanner.nextDouble());



        while (!exit) {

            System.out.println("NOME DO PRODUTO: ");
            String name = scanner.next();
            System.out.println("PREÇO DO PRODUTO: ");
            double price = scanner.nextDouble();
            while (price <= 0) {
                System.out.println("DIGITE UM VALOR VÁLIDO!!");
                System.out.println("PREÇO DO PRODUTO: ");
                price = scanner.nextDouble();
            }
            Transaction transaction = new Transaction(name, price);


            if (transaction.getPrice() > user.getCredit()) {
                System.out.println("******SALDO INSUFICIENTE!!******");
                transaction.extract(transactionList);
                user.printCredit();
                exit = true;
            } else {
                user.setCredit(user.getCredit() - transaction.getPrice());
                user.printCredit();
                transactionList.add(transaction);
                System.out.println("*******COMPRA REALIZADA!!********");
            }



            System.out.println("**CONTINUAR? 's'(SIM) 'n' (NÃO)**");
            String exitApp = scanner.next();

            if (exitApp.equals("n")) {
                Collections.sort(transactionList);
                transaction.extract(transactionList);
                user.printCredit();
                exit = true;
            } else if (exitApp.equals("s")) {
                System.out.println("⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣⇣");
            } else {
                System.out.println("*********OPCÃO INVÁLIDA*********");
                System.out.println("*******PROGRAMA ENCERRADO*******");
                Collections.sort(transactionList);
                transaction.extract(transactionList);
                user.printCredit();
                exit = true;
            }
        }








    }
}
