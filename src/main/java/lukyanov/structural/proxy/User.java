package lukyanov.structural.proxy;

public class User {
    private double balance;

    public User(double balance) {
        this.balance = balance;
    }

    public double addCash(double cash) {
        balance = balance + cash;
        System.out.println("Added " + cash + " to user's account");
        return balance;
    }

    public double withdrawCash(double cash) {
        if (balance >= cash) {
            balance = balance - cash;
            System.out.println("Withdrawn " + cash + " from user's account");
            return balance;
        } else {
            System.out.println("There is no enough money on account, balance: " + balance +
                    ". Sum to withdraw: " + cash);
            return 0;
        }
    }
}
