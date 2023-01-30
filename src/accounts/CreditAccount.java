package accounts;

import clients.Client;

public class CreditAccount extends Account{
    public static final int MAX_BALANCE = 0;

    public CreditAccount(Client client) {
        super(client, MAX_BALANCE);
    }

    @Override
    public String toString() {
        return "[Кредитный] " + super.toString();
    }

    @Override
    public boolean canAdd(long amount) {
        return ((balance + amount) <= 0);
    }

    @Override
    public void add(long amount) {
        if (this.canAdd(amount)) {
            balance += amount;
        } else {
            System.out.println("Вносимая сумма больше кредитной задолженности");
        }
    }
}