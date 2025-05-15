package ex09.controller;

import java.awt.event.ActionEvent;

import ex08.DAO.AccountDAO;
import ex08.Model.Account;
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
    }

    public void onClickNewButton(ActionEvent e) {
        int number = mainView.getNumber();
        String owner = mainView.getAccountOwner();
        if (number > 0 && !owner.isBlank()) {
            double balance = mainView.getBalance();
            if (accountDAO.insertAccount( new Account(number, owner, balance)))
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
                return;
            }
            else {
                mainView.showWarning(
                    "An account with that number does not exist!");
            }
        }
        mainView.showAccountOwner("");
        mainView.blankBalance();
    }
}
