package com.company;



import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class ATM_Interface {
    public static void main(String args[]) {

        LocalDate d = LocalDate.now();
        String dateStr = d.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));

        LocalTime t = LocalTime.now();
        String timestr = t.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        String s = String.format("Date: %s", d);
        String ts = String.format("Time: %s", t);
        System.out.println(s);
        System.out.println(ts);

        //for logging in
        int user_id = 452071;
        int atmpin = 67890;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine! ");
        System.out.println("Enter your Id:  ");
        int num = sc.nextInt();
        System.out.println("Enter ATM PIN Number: ");
        int pin = sc.nextInt();

        if (user_id == num && atmpin == pin) {
            System.out.println("You have logged in successfully\n");
            BankAccount obj1 = new BankAccount("Vanshika Darji", "452003486", 5000);
            obj1.showMenu();
        }
        else{
            System.out.println("Please enter the correct login details(Invalid ATM Number or PIN Number)");
        }
    }
}
class BankAccount {
    int balance;
    int previousTransaction;
    String acc_name;
    String acc_number;

    BankAccount(String account_name, String account_number, int current_balance) {
        acc_name = account_name;
        acc_number = account_number;
        balance = 5000;
    }

    void deposit(int amount) {

        if (amount != 5000) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void Withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited : " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn : " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + acc_name + "!");
        System.out.println("Your account number is: " + acc_number);
        System.out.println("Your current balance is: " + balance);

        do {
            System.out.println("Select any transaction from the below options:");
            System.out.println("A. Check Balance ");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. TransactionHistory");
            System.out.println("E. Exit");
            System.out.println("-------------------------------------------------");
            System.out.print("Enter an option :");
            option = scanner.next().charAt(0);
            switch (option) {
                case 'A':
                case 'a':
                    System.out.println("--------------------------");
                    System.out.println("Balance =" + balance);
                    System.out.println("--------------------------");
                    break;
                case 'B':
                case 'b':
                    System.out.println("--------------------------");
                    System.out.print("Enter an amount to deposit :");
                    int amount = scanner.nextInt();
                    System.out.println("--------------------------");
                    deposit(amount);
                    System.out.println("Amount Deposited Successfully...");
                    break;
                case 'C':
                case 'c':
                    System.out.println("--------------------------");
                    System.out.print("Enter an amount to withdraw :");
                    int amount2 = scanner.nextInt();
                    System.out.println("--------------------------");
                    Withdraw(amount2);
                    System.out.println("Amount Withdrawn Successfully...");
                    break;
                case 'D':
                case 'd':
                    System.out.println("--------------------------");
                    getPreviousTransaction();
                    System.out.println("--------------------------");
                    break;
                case 'E':
                case 'e':
                    System.out.println("================================================");
                    System.out.println("Thankyou for banking with us.");
                    break;
            }
        }
        while (option != 'e');
    }
}
