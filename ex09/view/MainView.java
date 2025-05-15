package ex09.view;

import java.awt.event.ActionListener;

public interface MainView {

    void showNumber(int number);
    void showAccountOwner(String owner);
    void showBalance(double balance);
    void blankBalance();

    void showMessage(String message);
    void showWarning(String message);
    boolean confirmationDialog(String message);

    int getNumber();
    String getAccountOwner();
    double getBalance();

    void setShowButtonActionListener(ActionListener listener);
    void setNewButtonActionListener(ActionListener listener);
    void setDeleteButtonActionListener(ActionListener listener);
    void setBackwardButtonActionListener(ActionListener listener);
    void setForwardButtonActionListener(ActionListener listener);
}
