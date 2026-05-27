package chatbot;

import java.util.*;

public class NLPProcessor {

    public String detectIntent(String input) {
        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi"))
            return "greeting";

        if (input.contains("java"))
            return "java";

        if (input.contains("python"))
            return "python";

        if (input.contains("bye"))
            return "exit";

        if (input.contains("help"))
            return "help";

        return "unknown";
    }

    public List<String> tokenize(String input) {
        return Arrays.asList(input.toLowerCase().split(" "));
    }
}