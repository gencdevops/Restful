package org.javaturk.json.objectModel;

import javax.json.JsonValue;
import javax.json.JsonObject;
import javax.json.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonString;

public class GenericNavigator {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(
                "/Users/akin/Java/Eclipse/202009/workspace/JSON Processing/src/resource/person.json",
                Charset.forName("UTF-8"));
        JsonReader jsonReader = Json.createReader(fileReader);
        JsonValue personObject = jsonReader.readObject();

        navigateTree(personObject, null);
    }

    public static void navigateTree(JsonValue tree, String key) {
        if (key != null)
            System.out.print("Key " + key + ": ");
        switch (tree.getValueType()) {
            case OBJECT:
                System.out.println("OBJECT");
                JsonObject object = (JsonObject) tree;
                for (String name : object.keySet())
                    navigateTree(object.get(name), name);
                break;
            case ARRAY:
                System.out.println("ARRAY");
                JsonArray array = (JsonArray) tree;
                for (JsonValue val : array)
                    navigateTree(val, null);
                break;
            case STRING:
                JsonString st = (JsonString) tree;
                System.out.println("Type: STRING and Value: " + st.getString());
                break;
            case NUMBER:
                JsonNumber num = (JsonNumber) tree;
                System.out.println("Type: NUMBER and Value: " + num.toString());
                break;
            case TRUE:
            case FALSE:
            case NULL:
                System.out.println("Type: " + tree.getValueType().toString());
                break;
        }
    }
}
