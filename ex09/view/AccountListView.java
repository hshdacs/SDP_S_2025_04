package ex09.view;

import java.awt.BorderLayout;
import java.awt.ScrollPane;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class AccountListView extends JFrame {
    private JList<String> accountList = new JList<>();

    public AccountListView() {
        setTitle("Account List");
        setSize(250, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout( new BorderLayout() );
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(accountList, BorderLayout.CENTER);
        add(scrollPane);
//        add(accountList);
        JButton okayButton = new JButton("Okay");
        add(okayButton, BorderLayout.SOUTH );
        okayButton.addActionListener( e -> dispose() );
        pack();
        setVisible(true);
    }

    public void setListModel(DefaultListModel<String> listModel) {
        accountList.setModel(listModel);
    }
}
