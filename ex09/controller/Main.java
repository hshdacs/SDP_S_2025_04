package ex09.controller;

import ex09.dao.AccountDBbySQL;
import ex09.view.MainViewImpl;

public class Main {
    public static void main(String[] args) {
        new MainController(new MainViewImpl(), new AccountDBbySQL());
    }
}
