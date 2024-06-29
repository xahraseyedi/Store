import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class managerAccount extends storehouse implements ActionListener {

    private JFrame frame;
    private JPanel managerPanel;
    private JPanel usersPanel;
    private JPanel productsPanel;
    private JButton users;
    private JButton products;
    private JButton storeAccount;
    private JButton backButton;
    private JButton watchBands;
    private JButton phoneCharms;
    private JButton phoneCases;
    private JButton airpodCases;
    private ArrayList<JLabel> nameLabel;
    private AccountsInformation accountsInformation = new AccountsInformation(); // Object for managing accounts
    private JPanel panel;
    private JButton exit;

    // Constructor for initializing manager account interface
    public managerAccount(JFrame frame, AccountsInformation accountsInformation, JPanel panel) {
        this.frame = frame;
        this.accountsInformation = accountsInformation; // Assigning accounts information reference
        this.panel = panel; // Assigning main panel reference
        setManagerPanel();
        setButtons();
    }

    // Method to set up the manager panel interface
    private void setManagerPanel() {
        managerPanel = new JPanel();
        managerPanel.setBounds(0, 0, 800, 700);
        managerPanel.setBackground(Color.ORANGE);
        managerPanel.setLayout(null);

        frame.getContentPane().removeAll();
        frame.add(managerPanel);
        frame.repaint();
        frame.revalidate();
    }

    // Method to set up buttons for manager actions
    private void setButtons() {
        products = new JButton("محصولات");
        users = new JButton("کاربران");
        storeAccount = new JButton("حساب فروشگاه");
        exit = new JButton("برگشت");

        products.setBounds(300, 200, 200, 100);
        users.setBounds(300, 300, 200, 100);
        storeAccount.setBounds(300, 400, 200, 100);
        exit.setBounds(650, 630, 80, 25);

        products.addActionListener(this); // Adding action listener to products button
        users.addActionListener(this);
        storeAccount.addActionListener(this);
        exit.addActionListener(this);

        managerPanel.add(products);
        managerPanel.add(users);
        managerPanel.add(storeAccount);
        managerPanel.add(exit);
    }

    // Method to manage users
    private void users() {
        usersPanel = new JPanel();
        usersPanel.setBounds(0, 0, 800, 700);
        usersPanel.setBackground(Color.ORANGE);
        usersPanel.setLayout(null);
        ArrayList<JLabel> userinfo = new ArrayList<>();

        frame.getContentPane().removeAll();
        frame.add(usersPanel);
        frame.repaint();
        frame.revalidate();
    }

    // Method to manage products
    private void products() {
        productsPanel = new JPanel();
        productsPanel.setBounds(0, 0, 800, 700);
        productsPanel.setBackground(Color.ORANGE);
        productsPanel.setLayout(null);

        phoneCases = new JButton("Phone Case");
        airpodCases = new JButton("Airpod Case");
        phoneCharms = new JButton("Phone Charms");
        watchBands = new JButton("Watch Bands");
        backButton = new JButton("برگشت");

        phoneCases.setBounds(180, 210, 200, 120);
        airpodCases.setBounds(420, 210, 200, 120);
        phoneCharms.setBounds(180, 370, 200, 120);
        watchBands.setBounds(420, 370, 200, 120);
        backButton.setBounds(650, 600, 100, 50);

        phoneCases.addActionListener(this);
        airpodCases.addActionListener(this);
        phoneCharms.addActionListener(this);
        watchBands.addActionListener(this);
        backButton.addActionListener(this);

        productsPanel.add(phoneCases);
        productsPanel.add(airpodCases);
        productsPanel.add(phoneCharms);
        productsPanel.add(watchBands);
        productsPanel.add(backButton);
        frame.getContentPane().removeAll();
        frame.add(productsPanel);
        frame.repaint();
        frame.revalidate();
    }

    // Method to open watch band manager panel
    private void openWatchBandManagerPanel() {
        List<WatchBandManager> watchBands = Arrays.asList(
                new WatchBandManager("بند ساعت سیلیکونی", 200000, "C:\\Users\\eslam\\Downloads\\final\\a.jpg"),
                new WatchBandManager("بند ساعت طرح دار", 350000, "C:\\Users\\eslam\\Downloads\\final\\b.jpg"),
                new WatchBandManager("یند ساعت مدل زنجیره ای", 500000, "C:\\Users\\eslam\\Downloads\\final\\c.jpg")
        );
        WatchBandManagerPanel watchBandManagerPanel = new WatchBandManagerPanel(watchBands, frame);
        watchBandManagerPanel.setVisible(true);
        frame.setVisible(false);
    }

    // Method to open phone charm manager panel
    private void openPhoneCharmManagerPanel() {
        List<PhoneCharmManager> phoneCharms = Arrays.asList(
                new PhoneCharmManager("بند موبایل مدل طنابی", 100000, "C:\\Users\\eslam\\Downloads\\final\\d.jpg"),
                new PhoneCharmManager("بند موبایل طرح دار", 150000, "C:\\Users\\eslam\\Downloads\\final\\e.jpg"),
                new PhoneCharmManager("بند موبایل مدل کارتیر", 300000, "C:\\Users\\eslam\\Downloads\\final\\f.jpg")
        );
        PhoneCharmManagerPanel phoneCharmManagerPanel = new PhoneCharmManagerPanel(phoneCharms, frame);
        phoneCharmManagerPanel.setVisible(true);
        frame.setVisible(false);
    }

    // Method to open phone case manager panel
    private void openPhoneCaseManagerPanel() {
        List<PhoneCaseManager> phoneCases = Arrays.asList(
                new PhoneCaseManager("قاب گوشی مدل خرس", 200000, "C:\\Users\\eslam\\Downloads\\final\\ted1.jpg"),
                new PhoneCaseManager("قاب گوشی مدل خرگوش", 150000, "C:\\Users\\eslam\\Downloads\\final\\rabbit1.jpg"),
                new PhoneCaseManager("قاب گوشی مدل فضانورد", 300000, "C:\\Users\\eslam\\Downloads\\final\\space1.jpg")
        );
        PhoneCaseManagerPanel phoneCaseManagerPanel = new PhoneCaseManagerPanel(phoneCases, frame);
        phoneCaseManagerPanel.setVisible(true);
        frame.setVisible(false);
    }

    // Method to open airpod case manager panel
    private void openAirpodCaseManagerPanel() {
        List<AirpodCaseManager> airpodCases = Arrays.asList(
                new AirpodCaseManager("قاب ایرپاد مدل خرس", 100000, "C:\\Users\\eslam\\Downloads\\final\\teda1.jpg"),
                new AirpodCaseManager("قاب ایرپاد مدل گربه", 150000, "C:\\Users\\eslam\\Downloads\\final\\cat1.jpg"),
                new AirpodCaseManager("قاب ایرپاد مدل آووکادو", 200000, "C:\\Users\\eslam\\Downloads\\final\\avocado1.jpg")
        );
        AirpodCaseManagerPanel airpodCaseManagerPanel = new AirpodCaseManagerPanel(airpodCases, frame);
        airpodCaseManagerPanel.setVisible(true);
        frame.setVisible(false);
    }

    // Method to handle button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == users) {
            users();
        } else if (e.getSource() == products) {
            products();
        } else if (e.getSource() == watchBands) {
            openWatchBandManagerPanel();
        } else if (e.getSource() == phoneCharms) {
            openPhoneCharmManagerPanel();
        } else if (e.getSource() == phoneCases) {
            openPhoneCaseManagerPanel();
        } else if (e.getSource() == airpodCases) {
            openAirpodCaseManagerPanel();
        } else if (e.getSource() == backButton) {
            setManagerPanel();
            setButtons();
        }
        if (e.getSource() == exit) {
            frame.getContentPane().removeAll();
            frame.add(panel);
            frame.repaint();
            frame.revalidate();
        }
    }
}

