package ex08.Controller;

import java.util.Locale;

import ex08.DAO.AccountDAO;
import ex08.DAO.AccountDBbyInMemory;
import ex08.DAO.AccountDBbySQL;
import ex08.Model.Account;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
//        AccountDAO accountDB = new AccountDBbyInMemory();
        AccountDAO accountDB = new AccountDBbySQL();

        // accountDB.insertAccount( new Account(101, "Mr. Rich", 5001));
        // accountDB.insertAccount(new Account(102, "Mr. Poor", 16));
        // showAllAccounts(accountDB);

        // accountDB.deleteAccount(101);
        showAllAccounts(accountDB);
    }

    private static void showAllAccounts(AccountDAO accountDB) {
        for (Account account : accountDB.getAllAccounts()) {
            System.out.println(account);
        }
        System.out.println("---------------------------");
    }
}
