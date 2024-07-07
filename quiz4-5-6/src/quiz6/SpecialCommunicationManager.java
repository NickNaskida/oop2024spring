package quiz6;

import quiz5.CommunicationManager;

public class SpecialCommunicationManager {
    private String commonServiceUrl;
    private String specialServiceUrl;
    private CommunicationManager communicationManager;

    /**
     * Constructor for SpecialCommunicationManager
     * @param commonServiceUrl URL for common service
     * @param specialServiceUrl URL for special service
     */
    public SpecialCommunicationManager(String commonServiceUrl, String specialServiceUrl) {
        this.commonServiceUrl = commonServiceUrl;
        this.specialServiceUrl = specialServiceUrl;
        this.communicationManager = new CommunicationManager();
    }

    /**
     * Send request to the service URL based on the conversation history
     * @param conversationHistory Conversation history
     * @param jsonData JSON data to send
     * @return Response from the service
     * @throws Exception If an error occurs while sending the request
     */
    public String sendRequest(String conversationHistory, String jsonData) throws Exception {
        String serviceUrl = commonServiceUrl;

        // Check if the conversation history contains the keyword "help"
        if (conversationHistory != null && conversationHistory.contains("help")) {
            serviceUrl = specialServiceUrl;
        }

        return communicationManager.sendRequest(serviceUrl, jsonData);
    }
}
