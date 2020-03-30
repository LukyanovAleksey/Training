package lukyanov.structural.proxy;

public interface Bank {
    void putCash(User user, double cash);

    double getCash(User user, double cash);
}
