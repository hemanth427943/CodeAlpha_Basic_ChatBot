package chatbot;

import java.util.HashMap;
import java.util.Map;

public class KnowledgeBase {

    private Map<String, String> responses;

    public KnowledgeBase() {
        responses = new HashMap<>();

        responses.put("greeting", "Hello! How can I assist you today?");
        responses.put("java", "Java is a powerful object-oriented programming language.");
        responses.put("python", "Python is great for AI, ML, and automation.");
        responses.put("help", "You can ask me about Java, Python, or general programming.");
        responses.put("exit", "Goodbye! Have a great day!");
        responses.put("unknown", "Sorry, I didn't understand that.");
    }

    public String getResponse(String intent) {
        return responses.getOrDefault(intent, responses.get("unknown"));
    }
}