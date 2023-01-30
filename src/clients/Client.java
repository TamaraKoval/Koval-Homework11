package clients;

import accounts.Account;
import interfaces.MoneyTarget;

public class Client implements MoneyTarget {
    protected String name;
    protected Account[] accounts;

    public String getName() {
        return name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public Client(String name, int maxAccount) {
        this.name = name;
        this.accounts = new Account[maxAccount];
    }

    public void addAccount(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Превышено максимальное количество счетов!");
    }

    @Override
    public boolean canAdd(long amount) {
        for (int i = 0; i < accounts.length; i++ ) {
            if (accounts[i] == null) {
                break;
            }
            if (accounts[i].canAdd(amount)) {
                accounts[i].add(amount);
                return true;
            }
        }
        System.out.println("Нет подходящего счета для проведения операции");
        return false;
    }

    @Override
    public boolean canPay(long amount) {
        for (int i = 0; i < accounts.length; i++ ) {
            if (accounts[i] == null) {
                break;
            }
            if (accounts[i].canPay(amount)) {
                accounts[i].pay(amount);
                return true;
            }
        }
        System.out.println("Нет подходящего счета для проведения операции");
        return false;
    }
}