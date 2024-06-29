import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class userAccount extends storehouse implements ActionListener {

    private JFrame frame; // Main frame for the user account interface
    private JPanel userPanel;
    private JButton phoneCaseButton;
    private JButton airpodCaseButton;
    private JButton phoneCharm;
    private JButton watchBands;
    private JButton profile;
    private JButton cart;
    private JButton aboutStore;
    private Cart shoppingCart;
    private JButton backButton;
    private JPanel panel;

    // Constructor for user account with panel
    userAccount(JFrame frame, JPanel panel) {
        this.frame = frame;
        this.shoppingCart = new Cart(); // Initialize the cart
        this.panel = panel;

        setUserPanel();
        setButtons();
    }

    // Constructor for user account without panel
    userAccount(JFrame frame) {
        this.frame = frame;
        this.shoppingCart = new Cart(); // Initialize the cart

        setUserPanel();
        setButtons();
    }

    // Method to set up user panel
    private void setUserPanel() {
        userPanel = new JPanel();
        userPanel.setBounds(0, 0, 800, 700);
        userPanel.setBackground(Color.ORANGE);
        userPanel.setLayout(null);

        frame.getContentPane().removeAll();
        frame.add(userPanel);
        frame.repaint();
        frame.revalidate();
    }

    // Method to set up buttons on user panel
    private void setButtons() {
        phoneCaseButton = new JButton("Phone Case");
        airpodCaseButton = new JButton("Airpod Case");
        phoneCharm = new JButton("Phone Charm");
        watchBands = new JButton("Watch Bands");

        phoneCaseButton.setBounds(180, 210, 200, 120);
        airpodCaseButton.setBounds(420, 210, 200, 120);
        phoneCharm.setBounds(180, 370, 200, 120);
        watchBands.setBounds(420, 370, 200, 120);

        userPanel.add(phoneCaseButton);
        userPanel.add(phoneCharm);
        userPanel.add(airpodCaseButton);
        userPanel.add(watchBands);

        cart = new JButton("سبد خرید");
        profile = new JButton("حساب من");
        aboutStore = new JButton("درباره ما");
        backButton = new JButton("برگشت");

        profile.setBounds(5, 10, 80, 25);
        cart.setBounds(86, 10, 80, 25);
        aboutStore.setBounds(5, 640, 80, 25);
        backButton.setBounds(650, 630, 80, 25);

        userPanel.add(cart);
        userPanel.add(profile);
        userPanel.add(aboutStore);
        userPanel.add(backButton);

        profile.addActionListener(this);
        cart.addActionListener(this);
        aboutStore.addActionListener(this);
        backButton.addActionListener(this);

        phoneCharm.addActionListener(this);
        watchBands.addActionListener(this);
        phoneCaseButton.addActionListener(this);
        airpodCaseButton.addActionListener(this);
    }

    // Action listener for button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profile) {
            new myAccount(frame);
        }

        else if (e.getSource() == backButton) {
            frame.getContentPane().removeAll();
            frame.add(panel);
            frame.repaint();
            frame.revalidate();
        }

        else if (e.getSource() == cart) {
            new CartPanel(shoppingCart, frame);
        }

        else if (e.getSource() == phoneCharm) {
            SwingUtilities.invokeLater(() -> {
                List<PhoneCharm> phoneCharms = Arrays.asList(
                        new PhoneCharm("بند موبایل طنابی", 100000, "C:\\Users\\eslam\\Downloads\\final\\d.jpg"),
                        new PhoneCharm("بند موبایل طرح دار", 150000, "C:\\Users\\eslam\\Downloads\\final\\e.jpg"),
                        new PhoneCharm("بند موبایل مدل کارتیر", 300000, "C:\\Users\\eslam\\Downloads\\final\\f.jpg")
                );
                PhoneCharmPanel phoneCharmFrame = new PhoneCharmPanel(phoneCharms, frame, shoppingCart); // Pass the cart to the panel
                phoneCharmFrame.setVisible(true);
            });
            frame.dispose();
        }

        else if (e.getSource() == watchBands) {
            SwingUtilities.invokeLater(() -> {
                List<WatchBand> watchBands = Arrays.asList(
                        new WatchBand("بند ساعت سیلیکونی", 200000, "C:\\Users\\eslam\\Downloads\\final\\a.jpg"),
                        new WatchBand("بند ساعت طرح دار", 350000, "C:\\Users\\eslam\\Downloads\\final\\b.jpg"),
                        new WatchBand("بند ساعت مدل زنجیره ای", 500000, "C:\\Users\\eslam\\Downloads\\final\\c.jpg")
                );
                WatchBandPanel watchBandFrame = new WatchBandPanel(watchBands, frame, shoppingCart); // Pass the cart to the panel
                watchBandFrame.setVisible(true);
            });
            frame.setVisible(false); // Hide the current frame
        }

        else if (e.getSource() == phoneCaseButton) {
            SwingUtilities.invokeLater(() -> {
                List<phoneCase> phoneCases = Arrays.asList(
                        new phoneCase("قاب گوشی مدل خرس", 200000, "C:\\Users\\eslam\\Downloads\\final\\ted1.jpg"),
                        new phoneCase("قاب گوشی مدل خرگوش", 150000, "C:\\Users\\eslam\\Downloads\\final\\rabbit1.jpg"),
                        new phoneCase("قاب گوشی مدل فضانورد", 300000, "C:\\Users\\eslam\\Downloads\\final\\space1.jpg")
                );
                phoneCasePanel phoneCaseFrame = new phoneCasePanel(phoneCases, frame, shoppingCart); // Pass the cart to the panel
                phoneCaseFrame.setVisible(true);
            });
            frame.dispose();
        }

        else if (e.getSource() == airpodCaseButton) {
            SwingUtilities.invokeLater(() -> {
                List<AirpodCase> airpodCases = Arrays.asList(
                        new AirpodCase("قاب ایرپاد مدل خرس", 100000, "C:\\Users\\eslam\\Downloads\\final\\teda1.jpg"),
                        new AirpodCase("قاب ایرپاد مدل گربه", 150000, "C:\\Users\\eslam\\Downloads\\final\\cat1.jpg"),
                        new AirpodCase("قاب ایرپاد مدل آووکادو", 200000, "C:\\Users\\eslam\\Downloads\\final\\avocado1.jpg")
                );
                AirpodCasePanel airpodCaseFrame = new AirpodCasePanel(airpodCases, frame, shoppingCart); // Pass the cart to the panel
                airpodCaseFrame.setVisible(true);
            });
            frame.dispose();
        }

        else if (e.getSource() == aboutStore) {
            SwingUtilities.invokeLater(() -> {
                AboutUsPanel aboutUsFrame = new AboutUsPanel(); // Initialize about us panel
                aboutUsFrame.setVisible(true);
            });
        }
    }
}





