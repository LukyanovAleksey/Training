package lukyanov.structural.proxy;

public class BankImpl implements Bank {
    @Override
    public void putCash(User user, double cash) {
        user.addCash(cash);
    }

    @Override
    public double getCash(User user, double cash) {
        return user.withdrawCash(cash);
    }
}
