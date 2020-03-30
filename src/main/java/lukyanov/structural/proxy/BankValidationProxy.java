package lukyanov.structural.proxy;

/**
 * Validates that cash is more than 100 per 1 operation
 */
public class BankValidationProxy implements Bank {
    private Bank bank;

    public BankValidationProxy(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void putCash(User user, double cash) {
        if (cash > 100) {
            bank.putCash(user, cash);
        } else {
            System.out.println("Cash to put should be more 100");
        }
    }

    @Override
    public double getCash(User user, double cash) {
        if (cash > 100) {
            return bank.getCash(user, cash);
        }
        System.out.println("Cash to get should be more 100");
        return 0;
    }
}
