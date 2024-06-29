//https://stackoverflow.com/questions/36752957/adding-items-to-my-inventory-in-java
//youtube video
//faradars
//https://maktabkhooneh.org/mag/hashmap-in-java/
//https://darsman.com/blog/java/what-is-the-use-of-hashmap-in-java/
//https://javapro.ir/news_137063-utab
//https://blog.faradars.org/java-password-hashing/
//https://7learn.com/blog/hash-agorithms
//https://www.geeksforgeeks.org/hashing-data-structure/
//https://stackoverflow.com/questions/506029/whats-the-purpose-in-hashing-information

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class myAccount {

    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField balanceField;
    private JPasswordField passwordField;
    private JButton saveButton;
    private JButton addBalanceButton;
    private JButton backButton;

    private static final String FILE_PATH = "user_data.txt"; // File path for storing user data

    // Constructor for initializing account interface
    public myAccount(JFrame frame) {
        this.frame = frame;
        setPanel();
        setFieldsAndButtons();
        loadUserData(); // Loading existing user data if available
    }

    // Method to set up the main panel
    private void setPanel() {
        panel = new JPanel();
        panel.setBounds(0, 0, 800, 700);
        panel.setBackground(Color.ORANGE);
        panel.setLayout(null);

        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.repaint();
        frame.revalidate();
    }

    // Method to set up text fields and buttons
    private void setFieldsAndButtons() {
        JLabel usernameLabel = new JLabel("نام کاربری:");
        JLabel nameLabel = new JLabel("نام:");
        JLabel phoneLabel = new JLabel("شماره تلفن:");
        JLabel addressLabel = new JLabel("آدرس:");
        JLabel balanceLabel = new JLabel("موجودی:");
        JLabel passwordLabel = new JLabel("پسورد:");

        usernameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
        addressLabel.setFont(new Font("Arial", Font.BOLD, 15));
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));

        usernameField = new JTextField();
        nameField = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        balanceField = new JTextField();
        passwordField = new JPasswordField();

        saveButton = new JButton("ذخیره");
        addBalanceButton = new JButton("اضافه کردن موجودی");
        backButton = new JButton("برگشت");

        saveButton.setFont(new Font("Arial", Font.BOLD, 15));
        addBalanceButton.setFont(new Font("Arial", Font.BOLD, 15));
        backButton.setFont(new Font("Arial", Font.BOLD, 15));

        usernameLabel.setBounds(100, 50, 150, 25);
        usernameField.setBounds(250, 50, 150, 25);
        nameLabel.setBounds(100, 100, 150, 25);
        nameField.setBounds(250, 100, 150, 25);
        phoneLabel.setBounds(100, 150, 150, 25);
        phoneField.setBounds(250, 150, 150, 25);
        addressLabel.setBounds(100, 200, 150, 25);
        addressField.setBounds(250, 200, 150, 25);
        balanceLabel.setBounds(100, 250, 150, 25);
        balanceField.setBounds(250, 250, 150, 25);
        passwordLabel.setBounds(100, 300, 150, 25);
        passwordField.setBounds(250, 300, 150, 25);

        saveButton.setBounds(150, 400, 100, 30);
        addBalanceButton.setBounds(270, 400, 150, 30);
        backButton.setBounds(450, 400, 100, 30);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(balanceLabel);
        panel.add(balanceField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(saveButton);
        panel.add(addBalanceButton);
        panel.add(backButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUserData();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new userAccount(frame);
            }
        });

        addBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int currentBalance = Integer.parseInt(balanceField.getText());
                    String input = JOptionPane.showInputDialog(frame, "مبلغی را که می‌خواهید به موجودی اضافه کنید را وارد کنید:");
                    if (input != null && !input.isEmpty()) {
                        int amountToAdd = Integer.parseInt(input);
                        if (amountToAdd > 0) {
                            currentBalance += amountToAdd;
                            balanceField.setText(String.valueOf(currentBalance));
                            JOptionPane.showMessageDialog(frame, "مبلغ با موفقیت به موجودی اضافه شد!");
                        } else {
                            JOptionPane.showMessageDialog(frame, "لطفاً مبلغی معتبر وارد کنید!", "خطا", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "مقدار وارد شده نامعتبر است!", "خطا", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Method to save user data to file
    private void saveUserData() {
        String username = usernameField.getText();
        String name = nameField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String balance = balanceField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || name.isEmpty() || phone.isEmpty() || address.isEmpty() || balance.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "لطفاً همه‌ی فیلدها را پر کنید!", "خطا", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String hashedPassword = hashPassword(password);

        User user = new User(username, name, phone, address, balance, hashedPassword);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(user);
            JOptionPane.showMessageDialog(frame, "اطلاعات با موفقیت ذخیره شد!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "خطا در ذخیره اطلاعات!", "خطا", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to load existing user data from file
    private void loadUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            User user = (User) ois.readObject();
            usernameField.setText(user.getUsername());
            nameField.setText(user.getName());
            phoneField.setText(user.getPhone());
            addressField.setText(user.getAddress());
            balanceField.setText(user.getBalance());
        } catch (IOException | ClassNotFoundException e) {
            // No user data found or error in reading file
        }
    }

    // Method to hash password using SHA-256 algorithm
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}

// Class representing a user with various attributes
class User implements Serializable {
    private String username;
    private String name;
    private String phone;
    private String address;
    private String balance;
    private String password;

    // Constructor for initializing a user object
    public User(String username, String name, String phone, String address, String balance, String password) {
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
        this.password = password;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for phone number
    public String getPhone() {
        return phone;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Getter for balance
    public String getBalance() {
        return balance;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }
}
