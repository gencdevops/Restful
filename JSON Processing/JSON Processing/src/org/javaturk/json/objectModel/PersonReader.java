package org.javaturk.json.objectModel;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;

import org.javaturk.json.bean.Person;

public class PersonReader {

    public static void main(String[] args) throws IOException {
        PersonReader reader = new PersonReader();

        JsonReader jsonReader = reader.readJSONFile(
                "/Users/akin/Java/Eclipse/202009/workspace/JSON Processing/src/resource/person.json");

//        reader.readPersonObject(jsonReader);
        reader.readPersonStructure(jsonReader);

        // JsonReader jsonReader = reader.readJSONFile(
        // "/Users/akin/Java/Eclipse/202009/workspace/JSON Processing/src/resource/persons.json");
        //
        // reader.readPersons(jsonReader);

         jsonReader.close();
    }

    public JsonReader readJSONFile(String jsonFilePath) throws IOException {
        FileReader fileReader = new FileReader(jsonFilePath, Charset.forName("UTF-8"));
        JsonReader jsonReader = Json.createReader(fileReader);
        return jsonReader;
    }

    public void readPersonObject(JsonReader jsonReader) throws IOException {
        JsonObject personObject = jsonReader.readObject();
        System.out.println("Whole Object");
        System.out.println(personObject);
        
        readPerson(personObject);
    }

    public void readPersonStructure(JsonReader jsonReader) throws IOException {
        JsonStructure personStructure = jsonReader.readObject();
        System.out.println("Whole Structure");
        System.out.println(personStructure);

        readPerson((JsonObject)personStructure);
    }

    public void readPerson(JsonObject personObject) throws IOException {
        System.out.println("\n*** Person object ***");

        System.out.println("Id: " + personObject.getInt("id"));
        System.out.println("Name: " + personObject.getString("name"));
        System.out.println("Permanent: " + personObject.getBoolean("permanent"));
        JsonObject addressObject = personObject.getJsonObject("address");
        System.out.println("\nAddress: " + addressObject);
        System.out.println("Parts of the address");
        System.out.println("Street: " + addressObject.getString("street"));
        System.out.println("City: " + addressObject.getString("city"));
        System.out.println("Zipcode: " + addressObject.getInt("zipcode"));
        JsonArray phoneNumbersArray = personObject.getJsonArray("phoneNumbers");
        System.out.println("Phone numbers: " + phoneNumbersArray);
        JsonNumber number = phoneNumbersArray.getJsonNumber(0);
        System.out.println("First phone number: " + number.longValue());
        System.out.println("Second phone number: " + phoneNumbersArray.getInt(1));
        System.out.println("Sex: " + personObject.getString("sex"));
    }

    public void readPersons(JsonReader jsonReader) throws IOException {
        JsonArray personArray = jsonReader.readArray();
        System.out.println("There are " + personArray.size() + " person objects.");
        personArray.forEach(p -> {
            JsonObject o = p.asJsonObject();
            try {
                readPerson(o);
            } catch (IOException e) {
                System.out.println("Pronlem: " + e.getMessage());
            }
        });
    }
}
