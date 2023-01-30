package accounts;

import clients.Client;
import interfaces.MoneyTarget;

public abstract class Account implements MoneyTarget {
    protected String clientName;
    protected long balance;

    public String getClientName() {
        return clientName;
    }

    public long getBalance() {
        return balance;
    }

    public Account(Client client, long balance) {
        this.clientName = client.getName();
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "На счету " + clientName + ": " + balance;
    }
    @Override
    public boolean canPay(long amount) {
        return true;
    }
    public void pay(long amount) {
        balance -= amount;
    }
    @Override
    public boolean canAdd(long amount) {
        return true;
    }
    public void add(long amount) {
        balance += amount;
    }

    public boolean canTransfer(Account accountTo, long amount) {
        return (this.canPay(amount) && accountTo.canAdd(amount));
    }

    public void transfer(Account accountTo, long amount) {
        if (this.canTransfer(accountTo, amount)) {
            this.pay(amount);
            accountTo.add(amount);
            System.out.println("Операция прошла успешно");
        } else {
            System.out.println("Проведение операции невозможно");
        }
    }
}
