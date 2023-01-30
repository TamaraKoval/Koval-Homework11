package accounts;

import clients.Client;

public class SavingAccount extends Account{
    protected int minBalance;

    public int getMinBalance() {
        return minBalance;
    }

    public SavingAccount(Client client, long balance, int minBalance) {
        super(client, balance);
        this.minBalance = minBalance;
    }

    @Override
    public String toString() {
        return "[Накопительный] " + super.toString();
    }

    @Override
    public boolean canPay(long amount) {
        return ((balance - amount) >= minBalance);
    }

    @Override
    public void pay(long amount) {
        if (this.canPay(amount)) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств на счету");
        }
    }
}
