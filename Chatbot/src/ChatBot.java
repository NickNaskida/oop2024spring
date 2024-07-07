import services.WeatherService;
import services.CurrencyService;

import java.util.Scanner;

public class ChatBot {
    private WeatherService weatherService;
    private CurrencyService currencyService;

    public ChatBot() {
        weatherService = new WeatherService("your_openweathermap_api_key");
        currencyService = new CurrencyService("your_exchangerate_api_key");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! I can provide current weather and currency exchange rates. Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (input.toLowerCase().startsWith("weather")) {
                if (input.length() > 8) {
                    String city = input.substring(8).trim();
                    try {
                        String weather = weatherService.getCurrentWeather(city);
                        System.out.println("Bot: " + weather);
                    } catch (Exception e) {
                        System.out.println("Bot: Sorry, I couldn't fetch the weather for " + city);
                    }
                } else {
                    System.out.println("Bot: Please specify a city after 'weather'.");
                }
            } else if (input.toLowerCase().startsWith("rate")) {
                if (input.length() > 5) {
                    String[] currencies = input.substring(5).trim().split(" ");
                    if (currencies.length == 2) {
                        String baseCurrency = currencies[0].toUpperCase();
                        String targetCurrency = currencies[1].toUpperCase();
                        try {
                            String rate = currencyService.getExchangeRate(baseCurrency, targetCurrency);
                            System.out.println("Bot: " + rate);
                        } catch (Exception e) {
                            System.out.println("Bot: Sorry, I couldn't fetch the exchange rate from " + baseCurrency + " to " + targetCurrency);
                        }
                    } else {
                        System.out.println("Bot: Please specify the base and target currencies.");
                    }
                } else {
                    System.out.println("Bot: Please specify the base and target currencies after 'rate'.");
                }
            } else {
                System.out.println("Bot: I didn't understand that. Please ask for 'weather <city>' or 'rate <base_currency> <target_currency>'.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        ChatBot chatBot = new ChatBot();
        chatBot.start();
    }
}
