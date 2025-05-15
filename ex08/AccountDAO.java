package ex08;

public interface AccountDAO {
    // standard database operations:
    // CRUD aka RUDI
    // Create/Read/Update/Delete or Read/Update/Delete/Insert

    boolean insertAccount(Account account);

    Account getAccountByNumber(int number);
    Account getAccountByOwner(String owner);

    boolean updateAccount(int number, Account account);

    boolean deleteAccount(int number);

    int lastAccountNumber();
}
