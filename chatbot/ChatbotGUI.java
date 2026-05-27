package chatbot;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatbotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton, clearButton;
    private JLabel statusLabel;

    private ConversationEngine engine;

    public ChatbotGUI() {
        engine = new ConversationEngine(new NLPProcessor(), new KnowledgeBase());
        initializeGUI();
        addWelcomeMessage();
    }

    private void initializeGUI() {
        setTitle("IntelliBot Pro");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(chatArea);
        add(scroll, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());

        inputField = new JTextField();
        sendButton = new JButton("Send");
        clearButton = new JButton("Clear");

        JPanel buttons = new JPanel();
        buttons.add(sendButton);
        buttons.add(clearButton);

        bottom.add(inputField, BorderLayout.CENTER);
        bottom.add(buttons, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);

        statusLabel = new JLabel("Ready...");
        add(statusLabel, BorderLayout.NORTH);

        sendButton.addActionListener(e -> sendMessage());
        clearButton.addActionListener(e -> chatArea.setText(""));

        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String input = inputField.getText().trim();
        if (input.isEmpty()) return;

        append("YOU", input);

        String response = engine.processInput(input);

        append("BOT", response);

        inputField.setText("");
    }

    private void append(String sender, String msg) {
        chatArea.append("\n" + sender + ": " + msg + "\n");
    }

    private void addWelcomeMessage() {
        append("BOT", "Hello! I am IntelliBot Pro 🤖\nAsk me anything about programming!");
    }
}