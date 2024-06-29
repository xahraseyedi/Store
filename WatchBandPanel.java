import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class WatchBand {
    String name;
    double price;
    String imagePath;
    double rating; // Rating field

    // Constructor with name, price, image path, and rating parameters
    WatchBand(String name, double price, String imagePath, double rating) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.rating = rating;
    }

    // Constructor with name, price, and image path parameters (default rating 0)
    public WatchBand(String name, double price, String imagePath) {
        this(name, price, imagePath, 0); // Default rating
    }
}

public class WatchBandPanel extends JFrame {
    private JFrame previousFrame;
    private List<WatchBand> watchBands;
    private JPanel panel;
    private Cart cart;

    // Constructor with list of watch bands, previous frame, and cart parameters
    public WatchBandPanel(List<WatchBand> watchBands, JFrame previousFrame, Cart cart) {
        this.previousFrame = previousFrame;
        this.watchBands = watchBands;
        this.cart = cart;

        setTitle("WatchBands");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Using BoxLayout to arrange panels vertically
        panel.setBackground(Color.BLACK);

        JButton searchButton = new JButton("جستجو");
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 30));
        searchButton.addActionListener(e -> searchProducts(searchField.getText()));

        JButton sortButton = new JButton("مرتب سازی براساس قیمت");
        sortButton.addActionListener(e -> sortProductsByPrice());

        JPanel searchPanel = new JPanel();
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(sortButton);

        add(searchPanel, BorderLayout.NORTH);

        // Create panel for products and back button
        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton backButton = new JButton("برگشت");
        backButton.addActionListener(e -> {
            previousFrame.setVisible(true);
            dispose();
        });

        mainPanel.add(backButton, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(panel), BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);
        displayProducts(watchBands);
        setVisible(true);
    }

    public WatchBandPanel(List<WatchBand> watchBands) {}

    // Method to display products
    private void displayProducts(List<WatchBand> bands) {
        panel.removeAll();
        for (WatchBand band : bands) {
            JPanel bandPanel = new JPanel();
            bandPanel.setLayout(new BorderLayout());
            bandPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adding padding

            JLabel nameLabel = new JLabel(band.name);
            JLabel priceLabel = new JLabel("تومان " + band.price);
            JLabel ratingLabel = new JLabel("امتیاز: " + band.rating);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            priceLabel.setFont(new Font("Arial", Font.BOLD, 15));
            ratingLabel.setFont(new Font("Arial", Font.BOLD, 15));

            // Load and resize the image
            ImageIcon imageIcon = new ImageIcon(band.imagePath);
            Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(resizedImage);

            JLabel imageLabel = new JLabel(imageIcon);
            bandPanel.setBackground(Color.YELLOW);

            JPanel ratingPanel = new JPanel();
            JLabel rateLabel = new JLabel("امتیاز شما:");
            JTextField ratingField = new JTextField(1);
            JButton submitButton = new JButton("ثبت");

            submitButton.addActionListener(e -> {
                try {
                    double rating = Double.parseDouble(ratingField.getText());
                    if (rating >= 0 && rating <= 5) {
                        band.rating = rating;
                        ratingLabel.setText("امتیاز: " + band.rating);
                    } else {
                        JOptionPane.showMessageDialog(this, "امتیاز باید بین 0 و 5 باشد.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "لطفاً یک عدد معتبر وارد کنید.");
                }
            });

            JButton addToCartButton = new JButton("افزودن به سبد خرید");
            addToCartButton.addActionListener(e -> {
                cart.addItem(band);
                JOptionPane.showMessageDialog(this, "محصول به سبد خرید افزوده شد.");
            });

            JButton removeFromCartButton = new JButton("برداشتن از سبد خرید");
            removeFromCartButton.addActionListener(e -> {
                cart.removeItem(band);
                JOptionPane.showMessageDialog(this, "محصول از سبد خرید برداشته شد.");
            });

            ratingPanel.add(rateLabel);
            ratingPanel.add(ratingField);
            ratingPanel.add(submitButton);
            ratingPanel.add(addToCartButton);
            ratingPanel.add(removeFromCartButton);

            bandPanel.add(imageLabel, BorderLayout.CENTER);
            bandPanel.add(nameLabel, BorderLayout.NORTH);
            bandPanel.add(priceLabel, BorderLayout.SOUTH);
            bandPanel.add(ratingLabel, BorderLayout.EAST);
            bandPanel.add(ratingPanel, BorderLayout.WEST);

            panel.add(bandPanel);
        }
        panel.revalidate();
        panel.repaint();
    }

    // Method to search products
    private void searchProducts(String query) {
        List<WatchBand> filteredBands = watchBands.stream()
                .filter(band -> band.name.contains(query))
                .collect(Collectors.toList());
        displayProducts(filteredBands);
    }

    // Method to sort products by price
    private void sortProductsByPrice() {
        List<WatchBand> sortedBands = watchBands.stream()
                .sorted(Comparator.comparingDouble(band -> band.price))
                .collect(Collectors.toList());
        displayProducts(sortedBands);
    }
}


