package org.example;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese (日本語)");
        System.out.print("Select a language (1-4): ");

        Locale locale;
        boolean invalidInput = false;

        switch (scanner.nextLine()) {
            case "1" -> locale = new Locale("en", "US");
            case "2" -> locale = new Locale("fi", "FI");
            case "3" -> locale = new Locale("sv", "SE");
            case "4" -> locale = new Locale("ja", "JP");
            default -> {
                System.out.println("Invalid input. Defaulting to English.");
                invalidInput = true;
                locale = new Locale("en", "US");
            }
        }

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

        if(invalidInput) {
            System.out.println(messages.getString("language.option.invalid"));
        }

        TemperatureConverter converter = new TemperatureConverter();

        System.out.println(messages.getString("app.title"));

        System.out.println(MessageFormat.format(
                messages.getString("result.kelvinToCelsius"),
                100, converter.kelvinToCelsius(100)));

        System.out.println(MessageFormat.format(
                messages.getString("result.fahrenheitToCelsius"),
                32, converter.fahrenheitToCelsius(32)));

        System.out.println(MessageFormat.format(
                messages.getString("result.celsiusToFahrenheit"),
                0, converter.celsiusToFahrenheit(0)));

    }
}