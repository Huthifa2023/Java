public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount(1000 , 1000);
        BankAccount account2 = new BankAccount(99 , 99);
        BankAccount account3 = new BankAccount(5000 , 5000);
        BankAccount account4 = new BankAccount(7766 , 7766);

        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        System.out.println("the total money is =" + BankAccount.getTheTotalMoney());
        account1.getBalance();
        account1.depositMoneyChecking(500);
        account1.depositMoneySavings(500);
        account1.getBalance();
        System.out.println("\nthe total money is =" + BankAccount.getTheTotalMoney());
        System.out.println("number of accounts within the bank: " + BankAccount.getAllAccounts());
        account1.withdrawMoneyChecking(200);
        account1.withdrawMoneySavings(200);
        
        System.out.println(account1.getcheckingBalance());
        System.out.println(account1.getsavingsBalance());

        account1.getAccountNumber();
        account2.getAccountNumber();
        account3.getAccountNumber();
        account4.getAccountNumber();



        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney

        // Static Test (print the number of bank accounts and the totalMoney)

    }
}
