
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

// Class for managing product categories
public class ProductCategoryPanel extends JFrame {

    // Constructor to initialize the frame
    public ProductCategoryPanel() {
        setTitle("Shop");
        setSize(800, 700);
        setBackground(Color.ORANGE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 10, 10));

        // Creating buttons for product categories
        JButton phoneCaseButton = new JButton("Phone Case");
        JButton airpodCaseButton = new JButton("Airpod Case");
        JButton phoneCharmButton = new JButton("Phone Charm");
        JButton watchBandsButton = new JButton("Watch Bands");

        // Adding ActionListener to "PhoneCharm" button
        phoneCharmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    List<PhoneCharm> phoneCharms = Arrays.asList(
                            new PhoneCharm("بند موبایل مدل طنابی", 200000, "C:\\Users\\eslam\\Downloads\\final\\d.jpg"),
                            new PhoneCharm("بند موبایل طرح دار", 150000, "C:\\Users\\eslam\\Downloads\\final\\e.jpg"),
                            new PhoneCharm("بند موبایل مدل کارتیر", 300000, "C:\\Users\\eslam\\Downloads\\final\\f.jpg")
                    );
                    PhoneCharmPanel frame = new PhoneCharmPanel(phoneCharms);
                    frame.setVisible(true);
                });
                dispose();
            }
        });

        // Adding ActionListener to "PhoneCase" button
        phoneCaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    List<phoneCase> phoneCases = Arrays.asList(
                            new phoneCase("قاب گوشی مدل خرس", 200000, "C:\\Users\\eslam\\Downloads\\final\\ted1.jpg"),
                            new phoneCase("قاب گوشی مدل خرگوش", 150000, "C:\\Users\\eslam\\Downloads\\final\\rabbit1.jpg"),
                            new phoneCase("قاب گوشی مدل فضانورد", 300000, "C:\\Users\\eslam\\Downloads\\final\\space1.jpg")
                    );
                    phoneCasePanel frame = new phoneCasePanel(phoneCases);
                    frame.setVisible(true);
                });
                dispose();
            }
        });

        // Adding ActionListener to "AirpodCase" button
        airpodCaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    List<AirpodCase> airpodCases = Arrays.asList(
                            new AirpodCase("قاب ایرپاد مدل خرس", 100000, "C:\\Users\\eslam\\Downloads\\final\\teda1.jpg"),
                            new AirpodCase("قاب ایرپاد مدل گربه", 150000, "C:\\Users\\eslam\\Downloads\\final\\cat1.jpg"),
                            new AirpodCase("قاب ایرپاد مدل آووکادو", 200000, "C:\\Users\\eslam\\Downloads\\final\\avocado1.jpg")
                    );
                    AirpodCasePanel frame = new AirpodCasePanel(airpodCases);
                    frame.setVisible(true);
                });
                dispose();
            }
        });

        // Adding ActionListener to "WatchBands" button
        watchBandsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    List<WatchBand> watchBands = Arrays.asList(
                            new WatchBand("بند ساعت سیلیکونی", 400000, "C:\\Users\\eslam\\Downloads\\final\\a.jpg"),
                            new WatchBand("بند ساعت طرح دار", 350000, "C:\\Users\\eslam\\Downloads\\final\\b.jpg"),
                            new WatchBand("یند ساعت مدل زنجیره ای", 500000, "C:\\Users\\eslam\\Downloads\\final\\c.jpg")
                    );
                    WatchBandPanel frame = new WatchBandPanel(watchBands);
                    frame.setVisible(true);
                });
                dispose();
            }
        });


        add(phoneCaseButton);
        add(airpodCaseButton);
        add(phoneCharmButton);
        add(watchBandsButton);
    }
}
