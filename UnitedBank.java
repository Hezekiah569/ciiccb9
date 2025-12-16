import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class UnitedBank {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Map<String, Admin> admins = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeData();
        showMainMenu();
    }

    private static void initializeData() {
        Account user1 = new Account("user1", "pass1", "Jane Doe", 150000.00);
        Account user10 = new Account("user10", "pass10", "Yixuan", 300000.00);
        accounts.put("user1", user1);
        accounts.put("user10", user10);

        admins.put("admin", new Admin("admin", "admin123"));
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("============================================");
            System.out.println("|        Welcome to UnitedBank System      |");
            System.out.println("============================================");
            System.out.println("| 1. User Login                            |");
            System.out.println("| 2. Admin Login                           |");
            System.out.println("| 3. Exit                                  |");
            System.out.println("============================================");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                scanner.next(); // Consume invalid input
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    System.out.println("Thank you for using UnitedBank. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // ================= USER SECTION =================

    private static void userLogin() {
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (accounts.containsKey(username) && accounts.get(username).checkPassword(password)) {
            userMenu(accounts.get(username));
        } else {
            System.out.println("\nInvalid username or password.");
        }
    }

    private static void userMenu(Account account) {
        while (true) {
            System.out.println("\n============================================");
            System.out.println("User Menu - " + account.getFullName());
            System.out.println("============================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. View Account Details");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAccount Number: " + account.getAccountNumber());
                    System.out.printf("Your current Balance: $%.2f\n", account.getBalance());
                    break;
                case 2:
                    performDeposit(account);
                    break;
                case 3:
                    performWithdraw(account);
                    break;
                case 4:
                    performTransfer(account);
                    break;
                case 5:
                    account.displayAccountDetails();
                    break;
                case 6:
                    System.out.println("You have successfully logged out.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void performDeposit(Account account) {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        double oldBalance = account.getBalance();
        account.deposit(amount);

        System.out.println("\nDeposit successful.");
        System.out.printf("Old Balance:      $%.2f\n", oldBalance);
        System.out.printf("Amount Deposited: $%.2f\n", amount);
        System.out.printf("Your New Balance: $%.2f\n", account.getBalance());
    }

    private static void performWithdraw(Account account) {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        double oldBalance = account.getBalance();
        if (account.withdraw(amount)) {
            System.out.println("\nWithdraw successful.");
            System.out.printf("Old Balance:      $%.2f\n", oldBalance);
            System.out.printf("Amount Withdrawn: $%.2f\n", amount);
            System.out.printf("Your New Balance: $%.2f\n", account.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    private static void performTransfer(Account sender) {
        System.out.print("Enter recipient username: ");
        String recipientUser = scanner.nextLine();

        if (!accounts.containsKey(recipientUser) || recipientUser.equals(sender.getUsername())) {
            System.out.println("Recipient account not found or invalid.");
            return;
        }

        System.out.print("Enter amount to transfer: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        double oldSenderBalance = sender.getBalance();

        if (sender.withdraw(amount)) {
            Account recipient = accounts.get(recipientUser);
            recipient.deposit(amount);

            System.out.println("\nTransfer successful.");
            System.out.println("--- Transaction Details ---");
            System.out.println("Sender Details:");
            System.out.printf("  Account Number:     %s\n", sender.getAccountNumber());
            System.out.printf("  Amount Transferred: $%.2f\n", amount);
            System.out.println("Recipient Details:");
            System.out.printf("  Recipient:          %s\n", recipient.getFullName());
            System.out.printf("  Account Number:     %s\n", recipient.getAccountNumber());
            System.out.printf("  Amount Received:    $%.2f\n", amount);
            System.out.println("---------------------------");
            System.out.printf("Old Balance:      $%.2f\n", oldSenderBalance);
            System.out.printf("Your New Balance: $%.2f\n", sender.getBalance());
        } else {
            System.out.println("Transfer failed. Insufficient funds.");
        }
    }

    // ================= ADMIN SECTION =================

    private static void adminLogin() {
        System.out.print("\nEnter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (admins.containsKey(username) && admins.get(username).checkPassword(password)) {
            adminMenu();
        } else {
            System.out.println("\nInvalid admin credentials.");
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n============================================");
            System.out.println("|               Admin Menu                 |");
            System.out.println("============================================");
            System.out.println("1. View All Accounts");
            System.out.println("2. View Specific Account");
            System.out.println("3. Add Funds to Account");
            System.out.println("4. Deduct Funds from Account");
            System.out.println("5. Create New Account");
            System.out.println("6. Generate System Report");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewAllAccounts();
                    break;
                case 2:
                    viewSpecificAccount();
                    break;
                case 3:
                    modifyFunds(true);
                    break;
                case 4:
                    modifyFunds(false);
                    break;
                case 5:
                    createAccount();
                    break;
                case 6:
                    generateSystemReport();
                    break;
                case 7:
                    System.out.println("Logged out from Admin.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void viewAllAccounts() {
        System.out.println("\nAll Accounts in the System:");
        System.out.printf("%-15s %-20s %-15s %-15s %-10s\n", "Username", "Full Name", "Account Number", "Balance", "Status");
        System.out.println("-------------------------------------------------------------------------------");
        for (Account acc : accounts.values()) {
            System.out.printf("%-15s %-20s %-15s $%-14.2f %-10s\n",
                    acc.getUsername(),
                    acc.getFullName().length() > 20 ? acc.getFullName().substring(0, 17) + "..." : acc.getFullName(),
                    acc.getAccountNumber(),
                    acc.getBalance(),
                    "Active");
        }
    }

    private static void viewSpecificAccount() {
        System.out.print("Enter account username: ");
        String username = scanner.nextLine();
        if (accounts.containsKey(username)) {
            accounts.get(username).displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void modifyFunds(boolean isAdding) {
        System.out.print("Enter account username: ");
        String username = scanner.nextLine();

        if (!accounts.containsKey(username)) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Account acc = accounts.get(username);
        double oldBalance = acc.getBalance();

        if (isAdding) {
            acc.deposit(amount);
            System.out.println("Funds added successfully.");
        } else {
            if (!acc.withdraw(amount)) {
                System.out.println("Insufficient funds or invalid amount.");
                return;
            }
            System.out.println("Funds deducted successfully.");
        }

        System.out.printf("Old Balance:     $%.2f\n", oldBalance);
        System.out.printf("New Balance:     $%.2f\n", acc.getBalance());
        System.out.printf("Account Holder:  %s\n", acc.getFullName());
    }

    private static void createAccount() {
        System.out.print("Enter new username: ");
        String newInfoUser = scanner.nextLine();
        if (accounts.containsKey(newInfoUser)) {
            System.out.println("Username already exists.");
            return;
        }

        System.out.print("Enter password: ");
        String newPass = scanner.nextLine();
        System.out.print("Enter full name: ");
        String newName = scanner.nextLine();

        double initialBalance = 1000 + new Random().nextInt(49000);
        Account newAcc = new Account(newInfoUser, newPass, newName, initialBalance);
        accounts.put(newInfoUser, newAcc);

        System.out.println("\nNew account created successfully.");
        System.out.printf("Account Number:  %s\n", newAcc.getAccountNumber());
        System.out.printf("Account Holder:  %s\n", newAcc.getFullName());
        System.out.printf("Initial Balance: $%.2f\n", initialBalance);
    }

    private static void generateSystemReport() {
        int totalAccounts = accounts.size();
        double totalBalance = 0;
        double highestBalance = 0;
        String richestUser = "N/A";

        for (Account acc : accounts.values()) {
            totalBalance += acc.getBalance();
            if (acc.getBalance() > highestBalance) {
                highestBalance = acc.getBalance();
                richestUser = acc.getUsername() + " (" + acc.getAccountNumber() + ")";
            }
        }

        System.out.println("\n=================================");
        System.out.println("         System Report           ");
        System.out.println("=================================");
        System.out.printf("Total Accounts:       %d\n", totalAccounts);
        System.out.printf("Active Accounts:      %d\n", totalAccounts); // Assuming all active for now
        System.out.printf("Inactive Accounts:    %d\n", 0);
        System.out.printf("Total System Balance: $%.2f\n", totalBalance);
        System.out.printf("Average Balance:      $%.2f\n", (totalAccounts > 0 ? totalBalance / totalAccounts : 0));
        System.out.printf("Highest Balance:      $%.2f\n", highestBalance);
        System.out.printf("Richest Account:      %s\n", richestUser);
        System.out.println("=================================");
    }

    // ================= DATA CLASSES =================

    static class Account {
        private String username;
        private String password;
        private String fullName;
        private double balance;
        private String accountNumber;

        public Account(String username, String password, String fullName, double balance) {
            this.username = username;
            this.password = password;
            this.fullName = fullName;
            this.balance = balance;
            this.accountNumber = generateAccountNumber();
        }

        private String generateAccountNumber() {
            Random rand = new Random();
            return "ZZZ" + String.format("%06d", rand.nextInt(1000000));
        }

        public boolean checkPassword(String inputPass) {
            return this.password.equals(inputPass);
        }

        public void deposit(double amount) {
            if (amount > 0) this.balance += amount;
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && this.balance >= amount) {
                this.balance -= amount;
                return true;
            }
            return false;
        }

        public void displayAccountDetails() {
            System.out.println("\n| Account Details");
            System.out.println("-------------------------");
            System.out.printf("Account Number: %s\n", accountNumber);
            System.out.printf("Username:       %s\n", username);
            System.out.printf("Full Name:      %s\n", fullName);
            System.out.printf("Balance:        $%.2f\n", balance);
            System.out.println("-------------------------");
        }

        // Getters
        public String getUsername() { return username; }
        public String getFullName() { return fullName; }
        public double getBalance() { return balance; }
        public String getAccountNumber() { return accountNumber; }
    }

    static class Admin {
        private String username;
        private String password;

        public Admin(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean checkPassword(String inputPass) {
            return this.password.equals(inputPass);
        }
    }
}