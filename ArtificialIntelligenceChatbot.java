import java.util.Scanner;

class ChatBot {

    public String getResponse(String message) {

        message = message.toLowerCase();

        if (message.contains("hello") || message.contains("hi")) {
            return "Hello! How can I help you today?";
        }

        else if (message.contains("name")) {
            return "I am CodeAlpha AI ChatBot.";
        }

        else if (message.contains("java")) {
            return "Java is a powerful object-oriented programming language.";
        }

        else if (message.contains("internship")) {
            return "Internships provide practical experience and industry exposure.";
        }

        else if (message.contains("course")) {
            return "I can help you with Java, Python, Data Structures and Algorithms.";
        }

        else if (message.contains("time")) {
            return java.time.LocalTime.now().toString();
        }

        else if (message.contains("date")) {
            return java.time.LocalDate.now().toString();
        }

        else if (message.contains("bye")) {
            return "Goodbye! Have a great day.";
        }

        else {
            return "Sorry, I don't understand. Please ask another question.";
        }
    }
}

public class ArtificialIntelligenceChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChatBot bot = new ChatBot();

        System.out.println("================================");
        System.out.println("     AI CHATBOT SYSTEM");
        System.out.println("================================");
        System.out.println("Type 'bye' to exit.");

        while (true) {

            System.out.print("\nYou : ");
            String userInput = sc.nextLine();

            String response = bot.getResponse(userInput);

            System.out.println("Bot : " + response);

            if (userInput.equalsIgnoreCase("bye")) {
                break;
            }
        }

        sc.close();
    }
}
