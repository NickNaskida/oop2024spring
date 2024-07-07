package quiz5;

public class DummyCommunicationManager extends CommunicationManager {

    @Override
    public String sendRequest(String urlString, String jsonData) {
        // Simulate success response for testing purposes
        return "Dummy success response";
    }
}

