import java.util.ArrayList;
import java.util.Scanner;

// Account class to handle bank operations
class Account {
    private String accountHolderName;
    private double balance;
    private ArrayList<String> transactions;

    public Account(String name) {
        this.accountHolderName = name;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        transactions.add("Account created for: " + name);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactions.add("Deposited: ₹" + amount);
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        transactions.add("Withdrew: ₹" + amount);
        System.out.println("₹" + amount + " withdrawn successfully.");
    }

    public void viewBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("----- Transaction History -----");
        for (String t : transactions) {
            System.out.println(t);
        }
        System.out.println("-------------------------------");
    }
}

// Main class to simulate user interaction
public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bank Account Simulator");
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        Account account = new Account(name);

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. View Balance\n4. Transaction History\n5. Exit");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double deposit = scanner.nextDouble();
                    account.deposit(deposit);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdraw = scanner.nextDouble();
                    account.withdraw(withdraw);
                    break;
                case 3:
                    account.viewBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Account Simulator.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
