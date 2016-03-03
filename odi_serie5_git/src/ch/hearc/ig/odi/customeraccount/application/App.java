package ch.hearc.ig.odi.customeraccount.application;

import ch.hearc.ig.odi.customeraccount.business.Account;
import ch.hearc.ig.odi.customeraccount.business.Customer;

/**
 *
 * @author stephane.grangier
 */
public class App {

    public static void main(String[] args) {

        new App().run();
    }

    private void run() {

        //Création du client
        System.out.println("Création du client");
        Customer client = new Customer(1, "Pierre", "Le Riche");

        //Création des comptes du client
        System.out.println("Création des comptes du client");
        client.addAccount("1", "Compte courant", 0.5);
        client.addAccount("2", "Compte epargne", 1.5);
        client.addAccount("3", "Compte prevoyance", 2);

        //Créditer les comptes du client
        System.out.println("Créditer les comptes du client");
        client.getAccountByNumber("1").credit(10000);
        client.getAccountByNumber("2").credit(20000);
        client.getAccountByNumber("3").credit(30000);

        //Débiter les comptes du client
        System.out.println("Débiter les comptes du client");

        try {
            client.getAccountByNumber("1").debit(5000);
        } catch (IllegalStateException e) {
            System.out.println("Solde insuffisant sur le compte pour effectuer cette opération");
        }

        try {
            client.getAccountByNumber("2").debit(10000);
        } catch (IllegalStateException e) {
            System.out.println("Solde insuffisant sur le compte pour effectuer cette opération");
        }

        try {
            client.getAccountByNumber("3").debit(100000);
        } catch (IllegalStateException e) {
            System.out.println("Solde insuffisant sur le compte pour effectuer cette opération");
        }

        //Transfert entre comptes 1->2 du client
        System.out.println("Transfert entre comptes 1->2 du client");
        Account compteDebiter;
        Account compteCrediter;
        compteDebiter = client.getAccountByNumber("1");
        compteCrediter = client.getAccountByNumber("2");

        try {
            client.getAccountByNumber("1").transfer(5000, compteDebiter, compteCrediter);
        } catch (IllegalStateException e) {
            System.out.println("Solde insuffisant sur le compte pour effectuer cette opération");
        }

        //Transfert entre comptes 2->3 du client (solde insuf) --> erreur
        System.out.println("Transfert entre comptes 2->3 du client (solde insuf) --> erreur");
        compteDebiter = client.getAccountByNumber("2");
        compteCrediter = client.getAccountByNumber("3");

        try {
            client.getAccountByNumber("1").transfer(20000, compteDebiter, compteCrediter);
        } catch (IllegalStateException e) {
            System.out.println("Solde insuffisant sur le compte pour effectuer cette opération");
        }

    }

}
