import java.util.Scanner;

public class ATMInterface{
    private final BankAccount bankAccount;

    public ATMInterface(double initialBalance) {
        this.bankAccount = new BankAccount(initialBalance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= bankAccount.getBalance()) {
            bankAccount.updateBalance(-amount);
            System.out.println("Withdrawal successful. New balance: $" + bankAccount.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            bankAccount.updateBalance(amount);
            System.out.println("Deposit successful. New balance: $" + bankAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + bankAccount.getBalance());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMInterface atm = new ATMInterface(1000); // Initial balance

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                }
                case 2 -> {
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                }
                case 3 -> atm.checkBalance();
                case 4 -> {
                    System.out.println("Thank you for using the ATM!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
class BankAccount {
    private double accountBalance;

    public BankAccount(double initialBalance) {
        this.accountBalance = initialBalance;
    }

    public double getBalance() {
        return accountBalance;
    }

    public void updateBalance(double amount) {
        accountBalance += amount;
    }
}
