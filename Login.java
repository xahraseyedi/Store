import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JTextField phoneNumberTextField;
    private JTextField passwordTextField;
    private JLabel phoneNumberLabel;
    private JLabel passwordLabel;
    private JButton LoginButton;
    private JButton createAccountButton;
    private JPanel createPanel;
    private JLabel phoneNumberLabel2;
    private JLabel nameLabel;
    private JLabel passwordLabel2;
    private JTextField phoneNumberTextField2;
    private JTextField nameTextField;
    private JTextField passwordTextField2;
    private JButton button;
    private JButton backbutton;
    private JLabel errorLabel;
    private AccountsInformation accountsInformation = new AccountsInformation(); // Object for managing accounts
    private userAccount userAccount; // Object representing user account
    private managerAccount managerAccount; // Object representing manager account

    public Login() {

        frame = new JFrame("Shop");
        frame.setSize(800, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBounds(0, 0, 800, 700);
        panel.setBackground(Color.ORANGE);
        panel.setLayout(null);

        frame.add(panel);

        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setBounds(275, 180, 250, 40);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(275, 260, 250, 40);

        panel.add(phoneNumberTextField);
        panel.add(passwordTextField);

        phoneNumberLabel = new JLabel();
        phoneNumberLabel.setText("شماره موبایل:");
        phoneNumberLabel.setBounds(455, 120, 100, 100);
        passwordLabel = new JLabel();
        passwordLabel.setText("رمز عبور:");
        passwordLabel.setBounds(475, 200, 100, 100);

        panel.add(phoneNumberLabel);
        panel.add(passwordLabel);

        LoginButton = new JButton("ورود");
        LoginButton.setBounds(360, 340, 80, 40);
        LoginButton.addActionListener(this);
        createAccountButton = new JButton("ایجاد حساب کاربری جدید");
        createAccountButton.setBounds(325, 600, 150, 30);
        createAccountButton.addActionListener(this); // Adding action listener for create account button

        panel.add(LoginButton);
        panel.add(createAccountButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == LoginButton) {

            if (accountsInformation.checkAccount(phoneNumberTextField.getText(), passwordTextField.getText()).equals("user")) {
                userAccount = new userAccount(frame, panel); // Creating user account object for successful login
            } else if (accountsInformation.checkAccount(phoneNumberTextField.getText(), passwordTextField.getText()).equals("manager")) {
                managerAccount = new managerAccount(frame, accountsInformation, panel); // Creating manager account object for successful login
            } else {
                phoneNumberTextField.setText(" ");
                passwordTextField.setText(" ");
                //اطلاعات نامعتبر
            }
        } else if (e.getSource() == createAccountButton)
            addAccount();
    }

    public void addAccount() {
        createPanel = new JPanel();
        createPanel.setBounds(0, 0, 800, 700);
        createPanel.setBackground(Color.ORANGE);
        createPanel.setLayout(null);

        frame.remove(panel);
        frame.add(createPanel);
        frame.revalidate();
        frame.repaint();

        phoneNumberTextField2 = new JTextField();
        phoneNumberTextField2.setBounds(275, 260, 250, 40);
        nameTextField = new JTextField();
        nameTextField.setBounds(275, 180, 250, 40);
        passwordTextField2 = new JTextField();
        passwordTextField2.setBounds(275, 340, 250, 40);

        createPanel.add(phoneNumberTextField2);
        createPanel.add(nameTextField);
        createPanel.add(passwordTextField2);

        phoneNumberLabel2 = new JLabel();
        phoneNumberLabel2.setText("شماره موبایل :");
        phoneNumberLabel2.setBounds(451, 200, 100, 100);
        nameLabel = new JLabel();
        nameLabel.setText("نام و نام خوانوادگی :");
        nameLabel.setBounds(420, 120, 200, 100);
        passwordLabel2 = new JLabel();
        passwordLabel2.setText("رمز عبور :");
        passwordLabel2.setBounds(475, 280, 200, 100);
        errorLabel = new JLabel();
        errorLabel.setText(" ");
        errorLabel.setBounds(370, 70, 100, 100);

        createPanel.add(phoneNumberLabel2);
        createPanel.add(nameLabel);
        createPanel.add(passwordLabel2);

        button = new JButton("تایید");
        button.setBounds(360, 400, 80, 40);
        backbutton = new JButton("برگشت");
        backbutton.setBounds(650, 630, 80, 25);

        createPanel.add(button);
        createPanel.add(backbutton);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createPanel.remove(errorLabel);

                if (accountsInformation.checkName(nameTextField.getText()) &&
                        accountsInformation.checkPhoneNumber(phoneNumberTextField2.getText()) &&
                        accountsInformation.checkPassword(passwordTextField2.getText())) {

                    accountsInformation.addName(nameTextField.getText());
                    accountsInformation.addPhoneNumber(phoneNumberTextField2.getText());
                    accountsInformation.addPassword(passwordTextField2.getText());
                    accountsInformation.setWallet();

                    frame.remove(createPanel);
                    frame.add(panel);
                    frame.revalidate();
                    frame.repaint();
                } else {
                    createPanel.add(errorLabel);
                    errorLabel.setText("اطلاعات نامعتبر");
                }
            }
        });

        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(createPanel);
                frame.add(panel);
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}