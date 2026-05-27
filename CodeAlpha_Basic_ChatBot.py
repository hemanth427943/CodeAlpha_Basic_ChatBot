import datetime

def greet_user():
    hour = datetime.datetime.now().hour
    if hour < 12:
        return "Good morning!"
    elif hour < 18:
        return "Good afternoon!"
    else:
        return "Good evening!"

def chatbot():
    print("🤖 Smart Chatbot")
    print("Type 'help' to see what I can do.")
    print("Type 'bye' to exit.\n")

    name = None

    while True:
        user_input = input("You: ").lower().strip()

        # Greeting
        if any(word in user_input for word in ["hello", "hi", "hey"]):
            print(f"Bot: {greet_user()} How can I help you?")

        # Asking name
        elif "my name is" in user_input:
            name = user_input.split("my name is")[-1].strip().title()
            print(f"Bot: Nice to meet you, {name}!")

        elif "what is my name" in user_input:
            if name:
                print(f"Bot: Your name is {name}.")
            else:
                print("Bot: I don't know your name yet.")

        # How are you
        elif "how are you" in user_input:
            print("Bot: I'm doing great! Thanks for asking 😊")

        # Bot name
        elif "your name" in user_input:
            print("Bot: I'm your friendly chatbot 🤖")

        # Time
        elif "time" in user_input:
            current_time = datetime.datetime.now().strftime("%H:%M:%S")
            print(f"Bot: Current time is {current_time}")

        # Simple math
        elif "calculate" in user_input:
            try:
                expression = user_input.replace("calculate", "")
                result = eval(expression)
                print(f"Bot: The answer is {result}")
            except:
                print("Bot: Sorry, I couldn't calculate that.")

        # Help
        elif user_input == "help":
            print("Bot: I can respond to:")
            print("- Greetings (hi, hello)")
            print("- Your name (tell me your name)")
            print("- Time")
            print("- Simple calculations (e.g., calculate 2+2)")
            print("- General questions")

        # Exit
        elif "bye" in user_input:
            print("Bot: Goodbye! Have a great day 👋")
            break

        # Default response
        else:
            print("Bot: Hmm... I didn't understand that. Try typing 'help'.")

# Run chatbot
chatbot()