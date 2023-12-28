import java.util.Random;

public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;

    private static int accounts;      // all accounts in the Bank
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances

    // CONSTRUCTOR
    // Be sure to increment the number of accounts
    public BankAccount(double cBalance, double sBalance){
        this.checkingBalance = cBalance;
        this.savingsBalance = sBalance;
        this.accountNumber = createTenDigites();
        accounts += 1;
        totalMoney += sBalance + cBalance;
    }

    //create a random 10 digit for account number
    private String createTenDigites() {
        String randomNumber = "";
        for(int i=0; i<=10; i++){
            Random rand = new Random();
            randomNumber += String.valueOf(rand.nextInt(10));
        }
        return randomNumber;
    }

    // GETTERS
    // for checking, savings, accounts, and totalMoney
    public void getAccountNumber() {
        System.out.println( this + " acoount number: "+this.accountNumber);
    }
    public double getcheckingBalance() {
        return this.checkingBalance;
    }
    public double getsavingsBalance() {
        return this.savingsBalance;
    }
    public static int getAllAccounts() {
        return accounts;
    }
    public static double getTheTotalMoney() {
        return totalMoney;
    }

    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void depositMoneyChecking(double amount) {
        this.checkingBalance += amount;
        totalMoney += amount;
    }
    public void depositMoneySavings(double amount) {
        this.savingsBalance += amount;
        totalMoney += amount;
    }

    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    public void withdrawMoneyChecking(double amount) {
        this.checkingBalance -= amount;
        totalMoney -= amount;
    }
    public void withdrawMoneySavings(double amount) {
        this.savingsBalance -= amount;
        totalMoney -= amount;
    }
    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public void getBalance() {
        System.out.print("\nchecking Balance="+ this.checkingBalance + "," + "saving Balance=" + this.savingsBalance);
    }
}
