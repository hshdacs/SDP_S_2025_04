package ex09.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainViewImpl extends JFrame implements MainView {

    // Method 1 for Button actions
    public static class ExitButtonPerformer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("(M1) Yeah, I will exit and go home ...");
        }
    }

    public void onClickExitButton(ActionEvent event) {
        System.out.println("(M4) Well, that's a covenient way of exiting");
        dispose();
    }

    public MainViewImpl() {
        setTitle("Account Management");
        setSize(400, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addComponent();
        setVisible(true);
    }

    private void addComponent() {
        setLayout( new BorderLayout() );

        Panel bottomPanel = new Panel( new FlowLayout() );
        add( bottomPanel, BorderLayout.SOUTH );

        JButton exitButton = new JButton("Exit");
        bottomPanel.add( exitButton );

        // Method 1
        exitButton.addActionListener(new ExitButtonPerformer() );

        // Method 2
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("(M2) Yeah, this time I will really exit!");
                //dispose();
            }
        });

        // Method 3 (Lambda)
        exitButton.addActionListener( e -> { 
            System.out.println("(M3) Well, easy exit!!");
            dispose(); } );

        // Method 4 (Functional Interface)
        exitButton.addActionListener(this::onClickExitButton);
    }
}
