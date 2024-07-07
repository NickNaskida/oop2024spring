package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyService {
    private final String API_KEY;
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public CurrencyService(String apiKey) {
        this.API_KEY = apiKey;
    }

    public String getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        String urlString = BASE_URL + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency;
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

        return parseExchangeRate(responseBuilder.toString(), targetCurrency);
    }

    private String parseExchangeRate(String jsonResponse, String targetCurrency) {
        Map<String, Object> jsonMap = parseJson(jsonResponse);
        double rate = Double.parseDouble((String) jsonMap.get("conversion_rate"));
        String baseCode = (String) jsonMap.get("base_code");

        return String.format("Current exchange rate from %s to %s: %.4f.",
                baseCode, targetCurrency, rate);
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
