package ex08.DAO;

import java.util.ArrayList;
import java.util.List;

import ex08.Model.Account;

public class AccountDBbyInMemory extends AccountDBAbstract {
    private List<Account> accountList = new ArrayList<Account>();

    @Override
    public boolean insertAccount(Account account) {
        if ( findAccountByNumer(account.getNumber()) != null )
            return false;
        accountList.add(account.clone());
        return true;
    }

    private Account findAccountByNumer(int number) {
        for (Account account : accountList) {
            if (account.getNumber() == number)
                return account; 
        }
        return null;
    }

    @Override
    public Account getAccountByNumber(int number) {
        return findAccountByNumer(number).clone();
    }

    @Override
    public Account getAccountByOwner(String owner) {
        // TODO implement this indiviudally
        throw new UnsupportedOperationException("Unimplemented method 'getAccountByOwner'");
    }

    @Override
    public boolean deleteAccount(int number) {
        for (int i = 0; i < accountList.size(); i++) {
            if ( accountList.get(i).getNumber() == number ) {
                accountList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int lastAccountNumber() {
        int lastNumber = 0;
        for (Account account : accountList) {
            if (account.getNumber() > lastNumber)
                lastNumber = account.getNumber();
        }
        return lastNumber;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> copyList = new ArrayList<>();
        for (Account account : accountList) {
            copyList.add(account.clone());
        }
        return copyList;
    }
}
