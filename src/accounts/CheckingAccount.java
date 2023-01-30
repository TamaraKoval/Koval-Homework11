package accounts;

import clients.Client;

public class CheckingAccount extends Account{
    public static final int MIN_BALANCE = 0;

    public CheckingAccount(Client client, long balance) {
        super(client, balance);
    }

    @Override
    public String toString() {
        return "[Обыкновенный] " + super.toString();
    }


    @Override
    public boolean canPay(long amount) {
        return ((balance - amount) >= MIN_BALANCE);
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