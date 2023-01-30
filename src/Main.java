import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingAccount;
import clients.Client;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Client ivanov = new Client("Ivanov", 3);

        ivanov.addAccount(new SavingAccount(ivanov, 100000, 20000));
        ivanov.addAccount(new CheckingAccount(ivanov, 20000));
        ivanov.addAccount(new CreditAccount(ivanov));
        System.out.println(Arrays.toString(ivanov.getAccounts())); // завели 3 счета на клиента

        System.out.println();
        printSep();
        System.out.println();

        ivanov.getAccounts()[0].transfer(ivanov.getAccounts()[1], 50000); // переводим 50к с первого счета на второй
        System.out.println(Arrays.toString(ivanov.getAccounts())); // операция прошла успешно
        printSep();
        ivanov.getAccounts()[0].transfer(ivanov.getAccounts()[1], 50000); // пытаемся выйти за предел минимального баланса первого счета
        System.out.println(Arrays.toString(ivanov.getAccounts())); // операция не прошла, программа работает корректно
        printSep();
        ivanov.getAccounts()[1].transfer(ivanov.getAccounts()[2], 50000); // пытаемся перевести 50к на кредитный счет
        System.out.println(Arrays.toString(ivanov.getAccounts())); // операция не прошла, программа работает корректно
        printSep();
        ivanov.getAccounts()[2].transfer(ivanov.getAccounts()[0], 100000); // выходим в отрицательный баланс на кредитном счету
        System.out.println(Arrays.toString(ivanov.getAccounts())); // операция прошла успешно
        printSep();
        ivanov.getAccounts()[1].transfer(ivanov.getAccounts()[2], 50000); // еще раз пытаемся перевести 50к на кредитный счет
        System.out.println(Arrays.toString(ivanov.getAccounts())); // операция прошла успешно
    }

    public static void printSep() {
        System.out.println("-------------------------");
    }
}