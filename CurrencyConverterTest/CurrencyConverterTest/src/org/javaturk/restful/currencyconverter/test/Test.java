package org.javaturk.restful.currencyconverter.test;

import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import static javax.ws.rs.client.Invocation.Builder;

import org.javaturk.restful.currencyconverter.domain.Conversion;
import org.javaturk.restful.currencyconverter.domain.Conversions;
import org.javaturk.restful.currencyconverter.domain.Currency;
import static org.javaturk.restful.currencyconverter.domain.Currency.*;

public class Test {

    private static String conversionsUrl =
            "http://localhost:8080/CurrencyConverter/resources/conversions/";
    private static String convertUrl =
            "http://localhost:8080/CurrencyConverter/resources/conversions/{from}/{to}/{amount}";
    private static String convertUrlInString =
            "http://localhost:8080/CurrencyConverter/resources/conversions/string/{from}/{to}/{amount}";
    private static String currenciesUrl =
            "http://localhost:8080/CurrencyConverter/resources/conversions/currencies";

    public static void main(String[] args) {
//        getAllCurrencies();
//         sendConversionRequest();
        // sendConversionRequestInString();
        // sendConversionRequestObject();
         getConversions();
    }

    public static void sendConversionRequest() {
        System.out.println("\nSending a conversion request.");
        Currency sourceCurrency = TRY;
        Currency targetCurrency = USD;
        double sourceAmount = 2000;
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(convertUrl);
        target = target.resolveTemplate("from", sourceCurrency);
        target = target.resolveTemplate("to", targetCurrency);
        target = target.resolveTemplate("amount", sourceAmount);
        Builder builder = target.request();
        builder = builder.accept("application/json");
        Conversion conversion = builder.post(null, Conversion.class);
        System.out.println("Received conversion: " + conversion);
    }

    public static void sendConversionRequestInString() {
        System.out.println("\nSending a conversion request.");
        String sourceCurrency = "USD";
        String targetCurrency = "EUR";
        double sourceAmount = 1170;
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(convertUrlInString);
        target = target.resolveTemplate("from", sourceCurrency);
        target = target.resolveTemplate("to", targetCurrency);
        target = target.resolveTemplate("amount", sourceAmount);
        Builder builder = target.request();
        builder = builder.accept("application/json");
        Conversion conversion = builder.post(null, Conversion.class);
        System.out.println("Received conversion: " + conversion);
    }

    public static void sendConversionRequestObject() {
        System.out.println("\nSending a conversion object.");
        Client client = ClientBuilder.newClient();
        Conversion conversion = new Conversion(EUR, TRY, 1500);
        // Conversion conversion = new Conversion("USD", "TRY", 2000);
        // Conversion conversion = new Conversion("USD", "EUR", 12000);
        Conversion response = client.target(conversionsUrl).request().accept("application/json")
                .post(Entity.json(conversion), Conversion.class);
        System.out.println("Conversion: " + response);
    }

    public static void getConversions() {
        System.out.println("\nGetting All Conversions");
        Client client = ClientBuilder.newClient();
        Conversions conversions = client.target(conversionsUrl).request().accept("application/json")
                .get(Conversions.class);
        List<Conversion> conversionList = conversions.getConversions();
        System.out.println("Conversions: " + conversionList.size() + " objects.");
        for (Conversion c : conversionList)
            System.out.println(c);
    }

    public static void getAllCurrencies() {
        System.out.println("\nGetting All Currencies");
        Client client = ClientBuilder.newClient();
        List<String> list =
                client.target(currenciesUrl).request().accept("application/json").get(List.class);
        System.out.println("Currencies: " + list.size() + " objects.");
        for (String c : list)
            System.out.println(c);
    }
}
