package ex09.controller;

import ex08.DAO.AccountDBbySQL;
import ex09.view.MainViewImpl;

public class Main {
    public static void main(String[] args) {
        new MainController(new MainViewImpl(), new AccountDBbySQL());
    }
}
