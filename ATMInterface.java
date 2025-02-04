import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0; 
        }
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount +" Rs.");
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive number.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount +" Rs.");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive number.");
        } else {
            System.out.println("Insufficient balance for withdrawal. Your current balance is: " + balance + " Rs.");
        }
    }
    public double checkBalance() {
        return balance;
    }
}
class ATM {
    private BankAccount bankAccount;
    public ATM(BankAccount account) {
        this.bankAccount = account;
    }
    public void displayMenu() {
        System.out.println("\n---- Welcome to the ATM ----");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Please choose an option (1-4): ");
    }
    public void processATM() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;
                case 2: 
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3: 
                    System.out.println("Your current balance is: " + bankAccount.checkBalance()+" Rs.");
                    break;
                case 4: 
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-4).");
            }
        }
        scanner.close();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(50000.0);
        ATM atm = new ATM(account);
        atm.processATM();
    }
}
