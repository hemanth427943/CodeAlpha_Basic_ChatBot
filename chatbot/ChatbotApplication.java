package chatbot;

import javax.swing.SwingUtilities;

public class ChatbotApplication {
    public static void main(String[] args) {
        System.out.println("=== IntelliBot Pro - Advanced AI Assistant ===");

        SwingUtilities.invokeLater(() -> {
            try {
                ChatbotGUI gui = new ChatbotGUI();
                gui.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}