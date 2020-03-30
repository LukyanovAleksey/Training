package lukyanov.structural.proxy;

public class ProxyExample {
    public static void main(String[] args) {
        User user = new User(150);
        Bank bank = new BankImpl();
        bank = new BankValidationProxy(bank);
        bank.putCash(user, 110);
        bank.getCash(user, 300);
    }
}
