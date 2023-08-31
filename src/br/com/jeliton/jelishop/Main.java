package br.com.jeliton.jelishop;

import br.com.jeliton.jelishop.models.Transaction;
import br.com.jeliton.jelishop.models.User;

import javax.script.ScriptException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        boolean exit = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual limite do crédito: ");
        User user = new User(scanner.nextDouble());

        Transaction transaction = new Transaction();

        while (!exit) {

            System.out.println("Nome do produto: ");
            String name = scanner.nextLine();
            transaction.setName(name);

            
            System.out.println("Preço do produto: ");
            double price = scanner.nextDouble();
            transaction.setPrice(price);


            if (transaction.getPrice() > user.getCredit()) {
                System.out.println("Saldo insuficiente");
                break;
            } else {
                user.setCredit(user.getCredit() - transaction.getPrice());
                System.out.println(user.getCredit());
                System.out.println("Compra efetuada!! Deseja continuar ? ");
                System.out.println("Deseja continuar ou sair ?");
                String condition = scanner.nextLine();
                if (condition.equals("n")) {
                    break;
                }


            }
        }








    }
}
