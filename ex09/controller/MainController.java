package ex09.controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import ex09.model.AccountType;
import ex09.dao.AccountDAO;
import ex09.model.Account;
import ex09.view.AccountListView;
import ex09.view.MainView;

public class MainController {
    private MainView mainView;
    private AccountDAO accountDAO;

    public MainController(MainView mainView, AccountDAO accountDAO) {
        this.mainView = mainView;
        this.accountDAO = accountDAO;

        DefaultComboBoxModel<String> defaultModel = new DefaultComboBoxModel<>();
        for (AccountType accountType : AccountType.values()) {
            defaultModel.addElement( accountType.toString() );
        }
        mainView.setCboxAccountTypeModel(defaultModel);

        mainView.setShowButtonActionListener(this::onClickShowButton);
        mainView.setDeleteButtonActionListener(this::onClickDeleteButton);
        mainView.setNewButtonActionListener(this::onClickNewButton);
        mainView.setForwardButtonActionListener(this::onClickForwardButton);
        mainView.setBackwardButtonActionListener(this::onClickBackwardButton);
        mainView.setListButtonActionListener(this::onClickListButton);
    }

    public void onClickListButton(ActionEvent e) {
        AccountListView listView = new AccountListView();

        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        for (Account account : accountDAO.getAllAccounts()) {
            defaultListModel.addElement( account.toString() );
        }
        listView.setListModel(defaultListModel);
        mainView.enableWindow(false);

        listView.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {}

            @Override
            public void windowClosed(WindowEvent e) {
                mainView.enableWindow(true);
                mainView.getFocus();
            }

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
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
                    if (accountDAO.deleteAccount(number)) {
                        mainView.showMessage("Account deleted successfully");
                        blankAccountView();
                    }
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
        blankAccountView();
    }

    private void blankAccountView() {
        mainView.showAccountOwner("");
        mainView.blankBalance();
        mainView.showAccountType(AccountType.Silver);
    }
}
