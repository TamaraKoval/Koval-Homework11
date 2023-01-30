package interfaces;

public interface MoneyTarget {
    boolean canAdd (long amount);

    boolean canPay(long amount);
}
