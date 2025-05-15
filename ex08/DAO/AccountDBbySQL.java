package ex08.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex08.Model.Account;

public class AccountDBbySQL implements AccountDAO {
    private static final String SQL_MARIADB_HOST = "localhost";
    private static final String SQL_MARIADB_PORT = "3306";
    private static final String SQL_MARIADB_USER = "db2account";
    private static final String SQL_MARIADB_PASSWORD = "secret123";
    private static final String SQL_MARIADB_DATABASE = "db2account";

    private static final String SQL_MARIADB_CONNECTOR = "org.mariadb.jdbc.Driver";

    private Connection sqlConnection;

    public AccountDBbySQL() {
        try {
            Class.forName(SQL_MARIADB_CONNECTOR);
        } catch (ClassNotFoundException e) {
            System.err.println("Could not find required SQL driver!");
            e.printStackTrace();
            System.exit(-1);
        }
        connect();
    }

    private void connect() {
        try {
            sqlConnection = DriverManager.getConnection(
                "jdbc:mariadb://" +
                SQL_MARIADB_HOST + ":" + SQL_MARIADB_PORT + "/" +
                SQL_MARIADB_DATABASE, SQL_MARIADB_USER, SQL_MARIADB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("Got some problem when establishing SQL connection");
            e.printStackTrace();
            System.exit(-2);
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
        List<Account> accountList = new ArrayList<>();
        // SELECT * FROM account;
        try {
            Statement sqlStatement = sqlConnection.createStatement();
            ResultSet dataTable = sqlStatement.executeQuery("SELECT number,owner,balance FROM account");
            while (dataTable.next()) {
                accountList.add(
                    new Account(
                        dataTable.getInt("number"), 
                        dataTable.getString("owner"), 
                        dataTable.getDouble("balance")
                    ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountList;
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
