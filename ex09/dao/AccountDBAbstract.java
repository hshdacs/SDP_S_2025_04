package ex09.dao;

import ex09.model.Account;

public abstract class AccountDBAbstract implements AccountDAO {

    @Override
    public boolean updateAccount(int number, Account account) {
        if ( ! deleteAccount(number) ) return false;
        return insertAccount(account);
   }

}
