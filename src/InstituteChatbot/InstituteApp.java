package InstituteChatbot;

import javax.swing.*;
import java.awt.*;

public class InstituteApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public InstituteApp() 
    {
        setTitle("Stanford University");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu homeMenu = new JMenu("Home");
        JMenu aboutUsMenu = new JMenu("About Us");
        JMenu historyMenu = new JMenu("History");
        JMenu contactUsMenu = new JMenu("Contact Us");

        menuBar.add(homeMenu);
        menuBar.add(aboutUsMenu);
        menuBar.add(historyMenu);
        menuBar.add(contactUsMenu);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());
        homePanel.add(new JLabel("<html>" +
                "<div style='padding: 20px;'>" +
                "<h1 style='text-align: center;'>Welcome to Stanford University</h1>" +
                "<h2>About Stanford University</h2>" +
                "<p>Stanford University is one of the world's leading teaching and research universities. " +
                "It is known for its entrepreneurial character, drawn from the legacy of its founders, Jane and Leland Stanford.</p>" +
                "<h2>Courses Offered</h2>" +
                "<ul>" +
                "<li><b>Computer Science</b> - B.Sc., M.Sc., Ph.D.</li>" +
                "<li><b>Engineering</b> - B.Eng., M.Eng., Ph.D.</li>" +
                "<li><b>Business</b> - BBA, MBA, Ph.D.</li>" +
                "<li><b>Arts</b> - B.A., M.A., Ph.D.</li>" +
                "</ul>" +
                "<h2>Legacy</h2>" +
                "<p>Since its opening in 1891, Stanford has been dedicated to finding solutions to big challenges " +
                "and to preparing students for leadership in a complex world.</p>" +
                "</div>" +
                "</html>"), BorderLayout.CENTER);

        
        JPanel aboutUsPanel = new JPanel();
        aboutUsPanel.setLayout(new BorderLayout());
        aboutUsPanel.add(new JLabel("<html>" +
                "<div style='padding: 20px;'>" +
                "<h1 style='text-align: center;'>About Us</h1>" +
                "<p>Stanford University is a place of discovery, creativity, and innovation. " +
                "Our mission is to promote the public welfare by exercising an influence in behalf of humanity and civilization, " +
                "teaching the blessings of liberty regulated by law, and inculcating love and reverence for the great principles of government " +
                "as derived from the inalienable rights of man to life, liberty, and the pursuit of happiness.</p>" +
                "<p>We are committed to providing a challenging education, an engaging research environment, and a supportive community that helps students thrive.</p>" +
                "</div>" +
                "</html>"), BorderLayout.CENTER);

        
        JPanel historyPanel = new JPanel();
        historyPanel.setLayout(new BorderLayout());
        historyPanel.add(new JLabel("<html>" +
                "<div style='padding: 20px;'>" +
                "<h1 style='text-align: center;'>History</h1>" +
                "<p>Stanford University was founded in 1885 by California senator Leland Stanford and his wife, Jane, " +
                "in memory of their only child, Leland Jr., who died of typhoid fever at age 15. The Stanfords decided to create a university " +
                "to benefit \"other people's children\" and promote public welfare.</p>" +
                "<p>Stanford opened its doors on October 1, 1891. The University's initial 555 students and 15 faculty members started with ambitions and goals " +
                "that have continued to shape Stanford's trajectory and its values.</p>" +
                "<p>Over the years, Stanford has developed into a global leader in higher education, with a distinguished history of faculty and alumni " +
                "who have shaped fields as diverse as the arts, business, engineering, law, medicine, and the sciences.</p>" +
                "</div>" +
                "</html>"), BorderLayout.CENTER);

        
        JPanel contactUsPanel = new JPanel();
        contactUsPanel.setLayout(new BorderLayout());
        ChatbotPanel chatbotPanel = new ChatbotPanel();
        contactUsPanel.add(chatbotPanel, BorderLayout.CENTER);

        cardPanel.add(homePanel, "Home");
        cardPanel.add(aboutUsPanel, "About Us");
        cardPanel.add(historyPanel, "History");
        cardPanel.add(contactUsPanel, "Contact Us");

        getContentPane().add(cardPanel);

        homeMenu.addMenuListener(new MenuActionListener("Home"));
        aboutUsMenu.addMenuListener(new MenuActionListener("About Us"));
        historyMenu.addMenuListener(new MenuActionListener("History"));
        contactUsMenu.addMenuListener(new MenuActionListener("Contact Us"));

        setVisible(true);
    }

    private class MenuActionListener implements javax.swing.event.MenuListener 
    {
        private String panelName;

        public MenuActionListener(String panelName) 
        {
            this.panelName = panelName;
        }

        @Override
        public void menuSelected(javax.swing.event.MenuEvent e) 
        {
            cardLayout.show(cardPanel, panelName);
        }

        @Override
        public void menuDeselected(javax.swing.event.MenuEvent e) 
        {
        }

        @Override
        public void menuCanceled(javax.swing.event.MenuEvent e) 
        {
        }
    }
}
