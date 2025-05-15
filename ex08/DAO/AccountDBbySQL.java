package ex08.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex08.Model.Account;

public class AccountDBbySQL extends AccountDBAbstract {
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
        // INSERT INTO account (number, owner, balance) VALUES (?, ?, ?);
        try {
            PreparedStatement sqlStatement = sqlConnection.prepareStatement(
                "INSERT INTO account (number, owner, balance) VALUES (?, ?, ?)");
            sqlStatement.setInt(1, account.getNumber());
            sqlStatement.setString(2, account.getOwner());
            sqlStatement.setDouble(3, account.getBalance());
            return sqlStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account getAccountByNumber(int number) {
        try {
            PreparedStatement sqlStatement = sqlConnection.prepareStatement(
                "SELECT owner,balance FROM account WHERE number = ?");
            sqlStatement.setInt(1, number);
            ResultSet dataTable = sqlStatement.executeQuery();
            if (dataTable.next()) {
                return new Account(
                        number,
                        dataTable.getString("owner"), 
                        dataTable.getDouble("balance")
                    );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
    public boolean deleteAccount(int number) {
        // DELETE FROM account WHERE number = ?;
        try {
            PreparedStatement sqlStatement = sqlConnection.prepareStatement(
                "DELETE FROM account WHERE number = ?");
            sqlStatement.setInt(1, number);
            return sqlStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int lastAccountNumber() {
        try {
            Statement sqlStatement = sqlConnection.createStatement();
            ResultSet dataTable = sqlStatement.executeQuery(
                "SELECT MAX(number) AS maxnumber FROM account");
            if (dataTable.next()) {
                return dataTable.getInt("maxnumber");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
}
