package ex09.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import ex09.model.AccountType;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainViewImpl extends JFrame implements MainView {

    private JButton showButton = new JButton("Show");
    private JButton newButton = new JButton("New");
    private JButton deleteButton = new JButton("Delete");
    private JButton forwardButton = new JButton("⮚");
    private JButton backwardButton = new JButton("⮘");
    private JTextField textAccountNumber = new JTextField();
    private JTextField textAccountOwner = new JTextField();
    private JTextField textAccountBalance = new JTextField();
    private JTextField textAccountType = new JTextField();

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
        pack();
        setVisible(true);
    }

    private void addComponent() {
        setLayout( new BorderLayout() );

        JPanel bottomPanel = new JPanel( new FlowLayout() );
        add( bottomPanel, BorderLayout.SOUTH );

        JPanel centerPanel = new JPanel( new GridLayout(4, 2) );
        centerPanel.setBorder(new EmptyBorder(5,5,5,5));
        add( centerPanel, BorderLayout.CENTER );

        centerPanel.add( new JLabel("Account number:") );
        centerPanel.add( textAccountNumber );
        centerPanel.add( new JLabel("Owner") );
        centerPanel.add( textAccountOwner );
        centerPanel.add( new JLabel("Current balance") );
        centerPanel.add( textAccountBalance );
        centerPanel.add( new JLabel("Account type") );
        centerPanel.add( textAccountType );

        // Button Example
        JButton exitButton = new JButton("Exit");
        bottomPanel.add(backwardButton);
        bottomPanel.add( showButton );
        bottomPanel.add( newButton );
        bottomPanel.add( exitButton );
        bottomPanel.add(deleteButton);
        bottomPanel.add(forwardButton);

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

    @Override
    public void showNumber(int number) {
        textAccountNumber.setText( String.valueOf(number) );
    }

    @Override
    public void showAccountOwner(String owner) {
        textAccountOwner.setText(owner);
    }

    @Override
    public void showBalance(double balance) {
        textAccountBalance.setText( String.valueOf(balance) );
    }

    @Override
    public void blankBalance() {
        textAccountBalance.setText("");
    }

    @Override
    public int getNumber() {
        int number = 0;
        try {
            number = Integer.parseInt( textAccountNumber.getText() );
        }
        catch (NumberFormatException ignored) {
            // silencing this exception
            //showWarning("Please, enter a valid account number");
        }
        return number;
    }

    @Override
    public void showAccountType(AccountType type) {
        textAccountType.setText( type.toString() );
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.valueOf( textAccountType.getText() );
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(
            this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showWarning(String message) {
        JOptionPane.showMessageDialog(
            this, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public boolean confirmationDialog(String message) {
        return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, message, "Question", JOptionPane.YES_NO_OPTION);
    }

    @Override
    public String getAccountOwner() {
        return textAccountOwner.getText();
    }

    @Override
    public double getBalance() {
        double balance = 0;
        try {
            balance = Double.parseDouble( textAccountBalance.getText() );
        }
        catch (NumberFormatException ex) {
            showMessage("Please, enter a valid account balance");
        }
        return balance;
    }

    @Override
    public void setShowButtonActionListener(ActionListener listener) {
        showButton.addActionListener(listener);
    }

    @Override
    public void setNewButtonActionListener(ActionListener listener) {
        newButton.addActionListener(listener);
    }

    @Override
    public void setDeleteButtonActionListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    @Override
    public void setBackwardButtonActionListener(ActionListener listener) {
        backwardButton.addActionListener(listener);
    }

    @Override
    public void setForwardButtonActionListener(ActionListener listener) {
        forwardButton.addActionListener(listener);
    }
}
