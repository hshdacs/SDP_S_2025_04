package ex09.controller;

import ex08.DAO.AccountDAO;
import ex09.view.MainView;

public class MainController {
    private MainView mainView;
    private AccountDAO accountDAO;

    public MainController(MainView mainView, AccountDAO accountDAO) {
        this.mainView = mainView;
        this.accountDAO = accountDAO;
    }

}
