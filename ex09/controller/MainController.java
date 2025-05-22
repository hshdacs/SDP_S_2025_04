package ex09.controller;

import java.awt.event.ActionEvent;

import ex09.model.AccountType;
import ex09.dao.AccountDAO;
import ex09.model.Account;
import ex09.view.MainView;

public class MainController {
    private MainView mainView;
    private AccountDAO accountDAO;

    public MainController(MainView mainView, AccountDAO accountDAO) {
        this.mainView = mainView;
        this.accountDAO = accountDAO;

        mainView.setShowButtonActionListener(this::onClickShowButton);
        mainView.setDeleteButtonActionListener(this::onClickDeleteButton);
        mainView.setNewButtonActionListener(this::onClickNewButton);
        mainView.setForwardButtonActionListener(this::onClickForwardButton);
        mainView.setBackwardButtonActionListener(this::onClickBackwardButton);
    }

    public void onClickForwardButton(ActionEvent e) {
        int number = mainView.getNumber();
        int lastNumber = accountDAO.lastAccountNumber();
        Account account = null;
        do {
            number++;
            if (number > lastNumber) number=1;
            account = accountDAO.getAccountByNumber(number);
        } while (account == null);
        mainView.showNumber(number);
        onClickShowButton(e);
    }

    public void onClickBackwardButton(ActionEvent e) {
        int number = mainView.getNumber();
        int lastNumber = accountDAO.lastAccountNumber();
        Account account = null;
        do {
            number--;
            if (number < 1) number = lastNumber;
            account = accountDAO.getAccountByNumber(number);
        } while (account == null);
        mainView.showNumber(number);
        onClickShowButton(e);
    }

    public void onClickNewButton(ActionEvent e) {
        int number = mainView.getNumber();
        String owner = mainView.getAccountOwner();
        AccountType type = mainView.getAccountType();
        if (number > 0 && !owner.isBlank()) {
            double balance = mainView.getBalance();
            if (accountDAO.insertAccount( new Account(number, owner, balance, type)))
                mainView.showMessage("Account added successfully");
            else   
                mainView.showWarning("Unable to add this account");
        }
        else
            mainView.showWarning("Please provide a valid account number and owner name");
    }

    public void onClickDeleteButton(ActionEvent e) {
        int number = mainView.getNumber();
        if (number > 0) {
            Account account = accountDAO.getAccountByNumber(number);
            if (account != null) {
                if (mainView.confirmationDialog("Do you really want to delete the account of " + account.getOwner())) {
                    if (accountDAO.deleteAccount(number))
                        mainView.showMessage("Account deleted successfully");
                }
            }
            else {
                mainView.showWarning("There is no account with that number!");
            }
        }
    }

    public void onClickShowButton(ActionEvent e) {
        int number = mainView.getNumber();
        if (number > 0) {
            Account account = accountDAO.getAccountByNumber(number);
            if (account != null) {
                mainView.showAccountOwner(account.getOwner());
                mainView.showBalance(account.getBalance());
                mainView.showAccountType(account.getAccountType());
                return;
            }
            else {
                mainView.showWarning(
                    "An account with that number does not exist!");
            }
        }
        mainView.showAccountOwner("");
        mainView.blankBalance();
        // TODO
    }
}
