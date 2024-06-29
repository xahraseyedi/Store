//https://toplearn.com/ShowQuestion/72449/%D9%85%D8%B1%D8%AA%D8%A8-%D8%B3%D8%A7%D8%B2%DB%8C-%D9%85%D8%AD%D8%B5%D9%88%D9%84%D8%A7%D8%AA%D8%AA
//https://stackoverflow.com/questions/45490815/sorting-objects-in-an-arraylist-by-price-attributes
//https://www.freecodecamp.org/news/how-to-sort-a-list-in-java/
//https://www.javaguides.net/2023/10/java-sort-custom-objects-in-ascending-and-descending-order.html
//https://www.w3-farsi.com/posts/8289/search-for-strings-in-java/
//https://stackoverflow.com/questions/22213496/searching-a-list-of-items-with-a-specific-name
//https://docs.relewise.com/docs/examples/java/search/product-search-with-java.html
//https://www.geeksforgeeks.org/searching-algorithms-in-java/

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

class PhoneCharmManager {
    String name;
    double price;
    String imagePath;

    // Constructor with name, price, and image path parameters
    PhoneCharmManager(String name, double price, String imagePath) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }
}

public class PhoneCharmManagerPanel extends JFrame {
    private JFrame previousFrame;
    private List<PhoneCharmManager> phoneCharmManagers;
    private JPanel panel;

    // Constructor with list of phone charm managers and previous frame parameters
    public PhoneCharmManagerPanel(List<PhoneCharmManager> phoneCharmManagers, JFrame previousFrame) {
        this.previousFrame = previousFrame;
        this.phoneCharmManagers = phoneCharmManagers;

        setTitle("PhoneCharmManagers");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns layout
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

        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton backButton = new JButton("برگشت");
        backButton.addActionListener(e -> {
            previousFrame.setVisible(true);
            dispose();
        });

        mainPanel.add(backButton, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(panel), BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
        displayProducts(phoneCharmManagers);
    }

    public PhoneCharmManagerPanel(List<PhoneCharm> phoneCharms) {}

    // Method to display products
    private void displayProducts(List<PhoneCharmManager> charmManagers) {
        panel.removeAll();
        for (PhoneCharmManager charmManager : charmManagers) {
            JPanel charmManagerPanel = new JPanel();
            charmManagerPanel.setLayout(new BorderLayout());

            JLabel nameLabel = new JLabel(charmManager.name);
            JLabel priceLabel = new JLabel("تومان " + charmManager.price);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            priceLabel.setFont(new Font("Arial", Font.BOLD, 15));

            ImageIcon imageIcon = new ImageIcon(charmManager.imagePath);
            Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(resizedImage);

            JLabel imageLabel = new JLabel(imageIcon);
            charmManagerPanel.setBackground(Color.YELLOW);

            charmManagerPanel.add(imageLabel, BorderLayout.CENTER);
            charmManagerPanel.add(nameLabel, BorderLayout.NORTH);
            charmManagerPanel.add(priceLabel, BorderLayout.SOUTH);

            panel.add(charmManagerPanel);
        }
        panel.revalidate();
        panel.repaint();
    }

    // Method to search products
    private void searchProducts(String query) {
        List<PhoneCharmManager> filteredCharms = phoneCharmManagers.stream()
                .filter(charmManager -> charmManager.name.contains(query))
                .collect(Collectors.toList());
        displayProducts(filteredCharms);
    }

    // Method to sort products by price
    private void sortProductsByPrice() {
        List<PhoneCharmManager> sortedCharms = phoneCharmManagers.stream()
                .sorted(Comparator.comparingDouble(charmManager -> charmManager.price))
                .collect(Collectors.toList());
        displayProducts(sortedCharms);
    }
}

