import javax.swing.*;
import java.awt.*;

public class AboutUsPanel extends JFrame {
    public AboutUsPanel() {
        setTitle("About Us");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);   // Centering the window on the screen

        JTextArea aboutText = new JTextArea();
        aboutText.setText("                                     .این فروشگاه بهترین محصولات را با قیمت‌های مناسب ارائه می‌دهد\n"
                + "      محصولات ما شامل کاورهای موبایل، بندهای ساعت، بند های موبایل،کاور های هندزفری است\n"
                + "                                                                .آدرس: خیابان ولیعصر، پلاک شماره 123\n"
                + "                                                                                       تلفن:0123456789\n"
        );
        aboutText.setFont(new Font("Arial", Font.PLAIN, 20));
        aboutText.setLineWrap(true);   // Enabling line wrapping
        aboutText.setWrapStyleWord(true);   // Enabling word wrap
        aboutText.setEditable(false);    // Making the text area non-editable

        // Adding the JTextArea to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(aboutText);
        add(scrollPane);
    }
}