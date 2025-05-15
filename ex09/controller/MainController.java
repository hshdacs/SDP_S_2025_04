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
        }
        mainView.showAccountOwner("");
        mainView.blankBalance();
    }
}
