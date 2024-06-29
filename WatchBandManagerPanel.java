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

class WatchBandManager {
    String name;
    double price;
    String imagePath;

    // Constructor with name, price, and image path parameters
    WatchBandManager(String name, double price, String imagePath) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }
}

public class WatchBandManagerPanel extends JFrame {
    private JFrame previousFrame;
    private List<WatchBandManager> watchBandManagers;
    private JPanel panel;

    // Constructor with list of watch band managers and previous frame parameters
    public WatchBandManagerPanel(List<WatchBandManager> watchBandManagers, JFrame previousFrame) {
        this.previousFrame = previousFrame;
        this.watchBandManagers = watchBandManagers;

        setTitle("WatchBandManagers");
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
        displayProducts(watchBandManagers);
    }

    public WatchBandManagerPanel(List<WatchBand> watchBands) {}

    // Method to display products
    private void displayProducts(List<WatchBandManager> bandManagers) {
        panel.removeAll();
        for (WatchBandManager bandManager : bandManagers) {
            JPanel bandManagerPanel = new JPanel();
            bandManagerPanel.setLayout(new BorderLayout());

            JLabel nameLabel = new JLabel(bandManager.name);
            JLabel priceLabel = new JLabel("تومان " + bandManager.price);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            priceLabel.setFont(new Font("Arial", Font.BOLD, 15));

            ImageIcon imageIcon = new ImageIcon(bandManager.imagePath);
            Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(resizedImage);

            JLabel imageLabel = new JLabel(imageIcon);
            bandManagerPanel.setBackground(Color.YELLOW);

            bandManagerPanel.add(imageLabel, BorderLayout.CENTER);
            bandManagerPanel.add(nameLabel, BorderLayout.NORTH);
            bandManagerPanel.add(priceLabel, BorderLayout.SOUTH);

            panel.add(bandManagerPanel);
        }
        panel.revalidate();
        panel.repaint();
    }

    // Method to search products
    private void searchProducts(String query) {
        List<WatchBandManager> filteredBands = watchBandManagers.stream()
                .filter(bandManager -> bandManager.name.contains(query))
                .collect(Collectors.toList());
        displayProducts(filteredBands);
    }

    // Method to sort products by price
    private void sortProductsByPrice() {
        List<WatchBandManager> sortedBands = watchBandManagers.stream()
                .sorted(Comparator.comparingDouble(bandManager -> bandManager.price))
                .collect(Collectors.toList());
        displayProducts(sortedBands);
    }
}