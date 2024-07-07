package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherService {
    private final String API_KEY;
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public WeatherService(String apiKey) {
        this.API_KEY = apiKey;
    }

    public String getCurrentWeather(String city) throws Exception {
        String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }
        reader.close();

        return parseWeather(responseBuilder.toString());
    }

    private String parseWeather(String jsonResponse) {
        Map<String, Object> jsonMap = parseJson(jsonResponse);
        Map<String, Object> main = (Map<String, Object>) jsonMap.get("main");
        double temp = (double) main.get("temp");
        double feelsLike = (double) main.get("feels_like");
        String description = (String) ((Map<String, Object>) ((List<Object>) jsonMap.get("weather")).get(0)).get("description");
        String city = (String) jsonMap.get("name");

        return String.format("Current temperature in %s: %.1f°C, feels like %.1f°C. Weather: %s.",
                city, temp, feelsLike, description);
    }

    private Map<String, Object> parseJson(String json) {
        Map<String, Object> map = new HashMap<>();
        json = json.trim().substring(1, json.length() - 1); // Remove curly braces
        String[] pairs = json.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // Split by comma, but not within quotes
        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            String key = keyValue[0].trim().replace("\"", "");
            String value = keyValue[1].trim();
            if (value.startsWith("{")) {
                map.put(key, parseJson(value));
            } else if (value.startsWith("[")) {
                map.put(key, parseJsonArray(value));
            } else {
                map.put(key, value.replace("\"", ""));
            }
        }
        return map;
    }

    private List<Object> parseJsonArray(String json) {
        List<Object> list = new ArrayList<>();
        json = json.trim().substring(1, json.length() - 1); // Remove square brackets
        String[] values = json.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // Split by comma, but not within quotes
        for (String value : values) {
            value = value.trim();
            if (value.startsWith("{")) {
                list.add(parseJson(value));
            } else if (value.startsWith("[")) {
                list.add(parseJsonArray(value));
            } else {
                list.add(value.replace("\"", ""));
            }
        }
        return list;
    }
}
