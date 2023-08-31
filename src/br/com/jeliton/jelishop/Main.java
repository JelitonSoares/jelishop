package br.com.jeliton.jelishop;

import br.com.jeliton.jelishop.models.Transaction;
import br.com.jeliton.jelishop.models.User;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        boolean exit = false;

        Scanner scanner = new Scanner(System.in);
        List<Transaction> compras = new ArrayList<>();

        System.out.println("Qual limite do crédito: ");
        User user = new User(scanner.nextDouble());

        Transaction transaction = new Transaction();

        while (!exit) {

            System.out.println("Nome do produto: ");
            String name = scanner.next();
            System.out.println("Preço do produto: ");
            double price = scanner.nextDouble();
            transaction.setName(name);
            transaction.setPrice(price);


            if (transaction.getPrice() > user.getCredit()) {
                System.out.println("Saldo insuficiente");
                break;
            } else {
                user.setCredit(user.getCredit() - transaction.getPrice());
                System.out.println(user.getCredit());
                compras.add(transaction);
                System.out.println("Compra efetuada!!");
            }

            System.out.println("Deseja continuar ?");
            if (scanner.next().equals("n")) {
                System.out.println(compras);
                exit = true;
            }
        }








    }
}
