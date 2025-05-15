package ex08.DAO;

import java.util.List;

import ex08.Model.Account;

public class AccountDBbySQL implements AccountDAO {
    private static final String SQL_MARIADB_HOST = "localhost";
    private static final String SQL_MARIADB_PORT = "3306";
    private static final String SQL_MARIADB_USER = "db2account";
    private static final String SQL_MARIADB_PASSWORD = "secret123";
    private static final String SQL_MARIADB_DATABASE = "db2account";

    private static final String SQL_MARIADB_CONNECTOR = "org.mariadb.jdbc.Driver";

    public AccountDBbySQL() {
        try {
            Class.forName(SQL_MARIADB_CONNECTOR);
        } catch (ClassNotFoundException e) {
            System.err.println("Could not find required SQL driver!");
            e.printStackTrace();
            System.exit(-1);
        }
    }


    @Override
    public boolean insertAccount(Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertAccount'");
    }

    @Override
    public Account getAccountByNumber(int number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountByNumber'");
    }

    @Override
    public Account getAccountByOwner(String owner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountByOwner'");
    }

    @Override
    public List<Account> getAllAccounts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAccounts'");
    }

    @Override
    public boolean updateAccount(int number, Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }

    @Override
    public boolean deleteAccount(int number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }

    @Override
    public int lastAccountNumber() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastAccountNumber'");
    }
    
}
