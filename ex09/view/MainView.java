package ex09.view;

import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import ex09.model.AccountType;

public interface MainView {

    void showNumber(int number);
    void showAccountOwner(String owner);
    void showBalance(double balance);
    void blankBalance();
    void showAccountType(AccountType type);

    void showMessage(String message);
    void showWarning(String message);
    boolean confirmationDialog(String message);

    int getNumber();
    String getAccountOwner();
    double getBalance();
    AccountType getAccountType();

    void setCboxAccountTypeModel(DefaultComboBoxModel<String> defaultModel);
    void setShowButtonActionListener(ActionListener listener);
    void setNewButtonActionListener(ActionListener listener);
    void setDeleteButtonActionListener(ActionListener listener);
    void setBackwardButtonActionListener(ActionListener listener);
    void setForwardButtonActionListener(ActionListener listener);
    void setListButtonActionListener(ActionListener listener);

    void enableWindow(boolean enabled);
    void getFocus();
}
