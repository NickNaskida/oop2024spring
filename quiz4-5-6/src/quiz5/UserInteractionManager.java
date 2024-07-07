package quiz5;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class UserInteractionManager {

    private CommunicationManager communicationManager;

    /**
     * Constructor for UserInteractionManager
     */
    public UserInteractionManager() {
        this.communicationManager = new CommunicationManager();
    }

    /**
     * Interact with the user by taking input and sending it to the server
     */
    public void interactWithUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your message:");

        String userMessage = scanner.nextLine();
        String sender = "User";

        // Create JSON structure for request
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setMessage(userMessage);
        chatRequest.setSender(sender);
        chatRequest.addChatHistory(userMessage, sender);

        String jsonRequest = chatRequest.toJson();

        try {
            String response = communicationManager.sendRequest("http://dummyurl.com/api", jsonRequest);
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            System.out.println("Error while communicating with server: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * ChatRequest class to represent the JSON structure for the chat request
     * Contains message, sender, and chat history
     */
    class ChatRequest {
        private String message;
        private String sender;
        private List<ChatHistory> chatHistoryList = new ArrayList<>();

        public void setMessage(String message) {
            this.message = message;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public void addChatHistory(String message, String sender) {
            ChatHistory chatHistory = new ChatHistory();
            chatHistory.setSender(sender);
            chatHistory.setMessage(message);
            chatHistory.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            chatHistoryList.add(chatHistory);
        }

        public String toJson() {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{")
                    .append("\"message\": \"").append(message).append("\",")
                    .append("\"sender\": \"").append(sender).append("\",")
                    .append("\"chat_history\": [");

            for (int i = 0; i < chatHistoryList.size(); i++) {
                ChatHistory history = chatHistoryList.get(i);
                jsonBuilder.append("{")
                        .append("\"sender\": \"").append(history.getSender()).append("\",")
                        .append("\"message\": \"").append(history.getMessage()).append("\",")
                        .append("\"created_at\": \"").append(history.getCreatedAt()).append("\"}");

                if (i < chatHistoryList.size() - 1) {
                    jsonBuilder.append(",");
                }
            }

            jsonBuilder.append("]}");
            return jsonBuilder.toString();
        }
    }

    /**
     * ChatHistory class to represent the chat history in the JSON structure
     * Contains sender, message, and created_at fields
     */
    class ChatHistory {
        private String sender;
        private String message;
        private String createdAt;

        public void setSender(String sender) {
            this.sender = sender;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getSender() {
            return sender;
        }

        public String getMessage() {
            return message;
        }

        public String getCreatedAt() {
            return createdAt;
        }
    }
}