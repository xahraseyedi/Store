import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartPanel extends JFrame {
    private Cart cart;
    private JFrame previousFrame;

    public CartPanel(Cart cart, JFrame previousFrame) {
        this.cart = cart;
        this.previousFrame = previousFrame;

        setTitle("سبد خرید");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Setting the layout of the panel to BoxLayout (Y-axis)

        for (PhoneCharm charm : cart.getPhoneCharmItems()) { // Looping through all phone charm items in the cart
            JPanel charmPanel = new JPanel();
            charmPanel.setBackground(Color.YELLOW);
            charmPanel.setLayout(new BorderLayout());
            charmPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameLabel = new JLabel(charm.name);
            JLabel priceLabel = new JLabel("تومان " + charm.price);

            charmPanel.add(nameLabel, BorderLayout.WEST);
            charmPanel.add(priceLabel, BorderLayout.EAST);

            panel.add(charmPanel);
        }

        for (phoneCase Case : cart.getPhoneCaseItems()) { // Looping through all phone case items in the cart
            JPanel CasePanel = new JPanel();
            CasePanel.setBackground(Color.PINK);
            CasePanel.setLayout(new BorderLayout());
            CasePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameLabel = new JLabel(Case.name);
            JLabel priceLabel = new JLabel("تومان " + Case.price);

            CasePanel.add(nameLabel, BorderLayout.WEST);
            CasePanel.add(priceLabel, BorderLayout.EAST);

            panel.add(CasePanel);
        }

        for (AirpodCase Case : cart.getAirpodCaseItems()) { // Looping through all Airpod case items in the cart
            JPanel CasePanel = new JPanel();
            CasePanel.setBackground(Color.green);
            CasePanel.setLayout(new BorderLayout());
            CasePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameLabel = new JLabel(Case.name);
            JLabel priceLabel = new JLabel("تومان " + Case.price);

            CasePanel.add(nameLabel, BorderLayout.WEST);
            CasePanel.add(priceLabel, BorderLayout.EAST);

            panel.add(CasePanel);
        }

        for (WatchBand Band : cart.getWatchBandItems()) { // Looping through all watch band items in the cart
            JPanel bandPanel = new JPanel();
            bandPanel.setBackground(Color.cyan);
            bandPanel.setLayout(new BorderLayout());
            bandPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameLabel = new JLabel(Band.name);
            JLabel priceLabel = new JLabel("تومان " + Band.price);

            bandPanel.add(nameLabel, BorderLayout.WEST);
            bandPanel.add(priceLabel, BorderLayout.EAST);

            panel.add(bandPanel);
        }

        JButton backButton = new JButton("برگشت");
        backButton.addActionListener(e -> {
            previousFrame.setVisible(true);
            dispose();
        });

        add(panel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
