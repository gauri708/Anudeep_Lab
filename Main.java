
import java.util.Scanner;

class Customer {
    private String name;
    private String accountNumber;

    public Customer(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }
}

class Account {
    private String accountNumber;
    private double balance;
    private Customer customer;

    public Account(Customer customer, double initialBalance) {
        this.accountNumber = customer.getAccountNumber();
        this.balance = initialBalance;
        this.customer = customer;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance is $" + balance + ".");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (0 < amount && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance is " + balance + ".");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Customer customer = new Customer(name, accountNumber);

     
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        Account account = new Account(customer, initialDeposit);

        
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
