package ex09.view;

import javax.swing.JFrame;

public class MainViewImpl extends JFrame implements MainView {

    public MainViewImpl() {
        setTitle("Account Management");
        setSize(400, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
