package ex09.view;

import java.awt.ScrollPane;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class AccountListView extends JFrame {
    private JList<String> accountList = new JList<>();

    public AccountListView() {
        setTitle("Account List");
        setSize(250, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(accountList);
        add(scrollPane);
//        add(accountList);
        pack();
        setVisible(true);
    }

    public void setListModel(DefaultListModel<String> listModel) {
        accountList.setModel(listModel);
    }
}
