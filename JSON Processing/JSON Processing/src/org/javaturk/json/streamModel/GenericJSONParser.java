package org.javaturk.json.streamModel;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class GenericJSONParser {

    public static void main(String[] args) throws FileNotFoundException {
        GenericJSONParser parser = new GenericJSONParser();
        parser.parse(
                "/Users/akin/Java/Eclipse/202009/workspace/JSON Processing/src/resource/person.json");
        System.out.println();
        parser.parse(
                "/Users/akin/Java/Eclipse/202009/workspace/JSON Processing/src/resource/employee.json");
    }

    public void parse(String path) throws FileNotFoundException {
        FileReader reader = new FileReader(path);
        JsonParser parser = Json.createParser(reader);

        System.out.println(" *** Start of Parsing ***");
        String key = null;
        String innerObject = null;
        Event event = parser.next();
        if (event == JsonParser.Event.START_OBJECT) {
            System.out.println("\n *** Start of Object ***");
            // System.err.println("Object: " + parser.getObject());
            while (parser.hasNext()) {
                event = parser.next();
                if (event == JsonParser.Event.KEY_NAME) { // That's a key name
                    key = parser.getString();
                    // System.err.println("Key: " + key);
                    event = parser.next();
                    if (event == JsonParser.Event.START_ARRAY) {
                        System.out.printf("Key: %-15s %-15s", key, "Array Value: [");
                        JsonArray array = parser.getArray();
                        array.forEach((i) -> System.out.printf("%-10s ", i));
                        System.out.print("]\n");

                    } else if (event == JsonParser.Event.START_OBJECT) { // That's an inner object
                        innerObject = key;
                        System.out.println("\n  Inner Object: " + innerObject);
                    }
                } else if (event == JsonParser.Event.END_OBJECT) {
                    if (innerObject != null) {
                        System.out.println("  Inner Object: " + innerObject + "\n");
                        innerObject = null;
                    } else
                        System.out.println("   *** End of Object ***\n");
                }

                if (event == JsonParser.Event.VALUE_STRING)
                    System.out.printf("Key: %-15s %-15s %-50s\n", key, "String Value: ",
                            parser.getString());
                else if (event == JsonParser.Event.VALUE_NUMBER)
                    System.out.printf("Key: %-15s %-15s %-50s\n", key, "Number Value: ",
                            parser.getValue());
                else if (event == JsonParser.Event.VALUE_TRUE)
                    System.out.printf("Key: %-15s %-15s %-50s\n", key, "TRUE Value: ",
                            parser.getValue());
                else if (event == JsonParser.Event.VALUE_FALSE)
                    System.out.printf("Key: %-15s %-15s %-50s\n", key, "False Value: ",
                            parser.getValue());
                else if (event == JsonParser.Event.VALUE_NULL)
                    System.out.printf("Key: %-15s %-15s %-50s\n", key, "Null Value: ",
                            parser.getValue());
            }
        }
    }
}
