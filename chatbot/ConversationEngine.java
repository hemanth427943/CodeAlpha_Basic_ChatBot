package chatbot;

public class ConversationEngine {

    private NLPProcessor nlp;
    private KnowledgeBase kb;

    public ConversationEngine(NLPProcessor nlp, KnowledgeBase kb) {
        this.nlp = nlp;
        this.kb = kb;
    }

    public String processInput(String input) {

        String intent = nlp.detectIntent(input);

        String response = kb.getResponse(intent);

        // Simple "learning" behavior (dynamic response)
        if (input.toLowerCase().contains("your name")) {
            return "I am IntelliBot Pro, your AI assistant!";
        }

        if (input.toLowerCase().contains("time")) {
            return "Current time feature can be added easily!";
        }

        return response;
    }
}