package ex08.DAO;

import ex08.Model.Account;

public abstract class AccountDBAbstract implements AccountDAO {

    @Override
    public boolean updateAccount(int number, Account account) {
        if ( ! deleteAccount(number) ) return false;
        return insertAccount(account);
   }

}
