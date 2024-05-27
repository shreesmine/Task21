package InstituteChatbot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotPanel extends JPanel {
    private JTextArea chatArea;
    private JTextField userInput;
    private JButton sendButton;

    public ChatbotPanel() 
    {
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        userInput = new JTextField();
        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(userInput, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userText = userInput.getText().trim();
                if (!userText.isEmpty()) {
                    chatArea.append("You: " + userText + "\n");
                    String response = getChatbotResponse(userText);
                    chatArea.append("Bot: " + response + "\n");
                    userInput.setText("");
                }
            }
        });

        userInput.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                sendButton.doClick();
            }
        });
    }

    private String getChatbotResponse(String input) 
    {
        input = input.toLowerCase();
        switch (input) 
        {
        case "hello":
            return "Hello! How can I assist you today?";
        case "what courses do you offer?":
            return "We offer a variety of courses including Computer Science, Engineering, Business, and Arts.";
        case "where are you located?":
            return "We are located at sangli, 416404, 100 feet road, Maharastra, India.";
        case "how can I contact the your office?":
            return "You can contact the admissions office at 7499902425 or email gkoffice@gmail.com";
        case "what are your office hours?":
            return "Our office hours are Monday to Friday, 9:30 AM to 6:30 PM.";
        case "what is the tuition fee?":
            return "Tuition fees vary by program. Please visit our website or contact the admissions office for detailed information.";
        case "do you offer scholarships?":
            return "Yes, we offer a variety of scholarships based on merit and financial need. Please visit our scholarship page for more details.";
        case "what is the application deadline?":
            return "The application deadline for the fall semester is June 1, and for the spring semester, it is November 1.";
        case "do you have accommodation facilities?":
            return "Yes, we have on-campus accommodation facilities for students. You can apply for housing through the student portal.";
        case "how should i apply?":
            return "You can apply online through our official website.";
        default:
            return "I'm sorry, I don't understand that question. Can you please ask something else?";
        }
    }
}
