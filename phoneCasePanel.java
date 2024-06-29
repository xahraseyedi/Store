//https://toplearn.com/ShowQuestion/72449/%D9%85%D8%B1%D8%AA%D8%A8-%D8%B3%D8%A7%D8%B2%DB%8C-%D9%85%D8%AD%D8%B5%D9%88%D9%84%D8%A7%D8%AA%D8%AA
//https://stackoverflow.com/questions/45490815/sorting-objects-in-an-arraylist-by-price-attributes
//https://www.freecodecamp.org/news/how-to-sort-a-list-in-java/
//https://www.javaguides.net/2023/10/java-sort-custom-objects-in-ascending-and-descending-order.html
//https://www.w3-farsi.com/posts/8289/search-for-strings-in-java/
//https://stackoverflow.com/questions/22213496/searching-a-list-of-items-with-a-specific-name
//https://docs.relewise.com/docs/examples/java/search/product-search-with-java.html
//https://www.geeksforgeeks.org/searching-algorithms-in-java/
//https://roocket.ir/discuss/%D8%B3%DB%8C%D8%B3%D8%AA%D9%85-%D8%A7%D9%85%D8%AA%DB%8C%D8%A7%D8%B2-%D8%AF%D9%87%DB%8C-%D8%A8%D9%87-%D9%85%D8%AD%D8%B5%D9%88%D9%84%D8%A7%D8%AA
//https://stackoverflow.com/questions/62564762/map-that-associate-a-rating-and-a-list-of-products-java


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// phoneCase class to hold phone case information
class phoneCase {
    String name;
    double price;
    String imagePath;
    double rating; // Rating field

    // Constructor with name, price, image path, and rating parameters
    phoneCase(String name, double price, String imagePath, double rating) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.rating = rating;
    }

    // Constructor with name, price, and image path parameters (default rating 0)
    public phoneCase(String name, double price, String imagePath) {
        this(name, price, imagePath, 0); // Default rating
    }
}

// phoneCasePanel class to display phone cases in the UI
class phoneCasePanel extends JFrame {
    private JFrame previousFrame;
    private List<phoneCase> phoneCases;
    private JPanel panel;
    private Cart cart;

    // Constructor with list of phone cases, previous frame, and cart parameters
    public phoneCasePanel(List<phoneCase> phoneCases, JFrame previousFrame, Cart cart) {
        this.previousFrame = previousFrame;
        this.phoneCases = phoneCases;
        this.cart = cart;

        setTitle("Phone Cases");
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
        displayProducts(phoneCases);
        setVisible(true);
    }

    public phoneCasePanel(List<phoneCase> phoneCases) {}

    // Method to display products
    private void displayProducts(List<phoneCase> Cases) {
        panel.removeAll();
        for (phoneCase Case : Cases) {
            JPanel CasePanel = new JPanel();
            CasePanel.setLayout(new BorderLayout());
            CasePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adding padding

            JLabel nameLabel = new JLabel(Case.name);
            JLabel priceLabel = new JLabel("تومان " + Case.price);
            JLabel ratingLabel = new JLabel("امتیاز: " + Case.rating);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            priceLabel.setFont(new Font("Arial", Font.BOLD, 15));
            ratingLabel.setFont(new Font("Arial", Font.BOLD, 15));

            // Load and resize the image
            ImageIcon imageIcon = new ImageIcon(Case.imagePath);
            Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(resizedImage);

            JLabel imageLabel = new JLabel(imageIcon);
            CasePanel.setBackground(Color.YELLOW);

            JPanel ratingPanel = new JPanel();
            JLabel rateLabel = new JLabel("امتیاز شما:");
            JTextField ratingField = new JTextField(1);
            JButton submitButton = new JButton("ثبت");

            submitButton.addActionListener(e -> {
                try {
                    double rating = Double.parseDouble(ratingField.getText());
                    if (rating >= 0 && rating <= 5) {
                        Case.rating = rating;
                        ratingLabel.setText("امتیاز: " + Case.rating);
                    } else {
                        JOptionPane.showMessageDialog(this, "امتیاز باید بین 0 و 5 باشد.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "لطفاً یک عدد معتبر وارد کنید.");
                }
            });

            JButton addToCartButton = new JButton("افزودن به سبد خرید");
            addToCartButton.addActionListener(e -> {
                cart.addItem(Case);
                JOptionPane.showMessageDialog(this, "محصول به سبد خرید افزوده شد.");
            });

            JButton removeFromCartButton = new JButton("برداشتن از سبد خرید");
            removeFromCartButton.addActionListener(e -> {
                cart.removeItem(Case);
                JOptionPane.showMessageDialog(this, "محصول از سبد خرید برداشته شد.");
            });

            ratingPanel.add(rateLabel);
            ratingPanel.add(ratingField);
            ratingPanel.add(submitButton);
            ratingPanel.add(addToCartButton);
            ratingPanel.add(removeFromCartButton);

            CasePanel.add(imageLabel, BorderLayout.CENTER);
            CasePanel.add(nameLabel, BorderLayout.NORTH);
            CasePanel.add(priceLabel, BorderLayout.SOUTH);
            CasePanel.add(ratingLabel, BorderLayout.EAST);
            CasePanel.add(ratingPanel, BorderLayout.WEST);

            panel.add(CasePanel);
        }
        panel.revalidate();
        panel.repaint();
    }

    // Method to search products
    private void searchProducts(String query) {
        List<phoneCase> filteredCases = phoneCases.stream()
                .filter(Case -> Case.name.contains(query))
                .collect(Collectors.toList());
        displayProducts(filteredCases);
    }

    // Method to sort products by price
    private void sortProductsByPrice() {
        List<phoneCase> sortedCases = phoneCases.stream()
                .sorted(Comparator.comparingDouble(Case -> Case.price))
                .collect(Collectors.toList());
        displayProducts(sortedCases);
    }
}
