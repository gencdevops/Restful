package org.javaturk.json.objectModel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.javaturk.json.bean.Person;

public class PersonWriter {

    public static void main(String[] args) throws IOException {
        JsonObject personObject = PersonBuilder.buildPerson1();
        Writer fileWriter = new FileWriter("/Users/akin/Java/Eclipse/202009/workspace/JSON Processing/src/resource/person_new1.json");
        JsonWriter writer = Json.createWriter(fileWriter );
        writer.writeObject(personObject);
        writer.close();
    }

    public static void crPerson() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder = builder.add("id", 22);
        builder = builder.add("name", "Jason Mason");
        builder = builder.add("permanent", true);
        builder = builder.add("sex", "Male");

        JsonArrayBuilder phoneNumBuilder = Json.createArrayBuilder();
        phoneNumBuilder.add(1234567890L);
        phoneNumBuilder.add(9876543210L);
        phoneNumBuilder.add(1122334455L);
        builder.add("phoneNumbers", phoneNumBuilder);

        JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
        addressBuilder.add("street", "vatan Cad. No 55/3");
        addressBuilder.add("city", "Istanbul");
        addressBuilder.add("zipcode", "34664");
        builder.add("address", addressBuilder);

        JsonObject jsonObject = builder.build();
        System.out.println("JSON Object: \n" + jsonObject);

        System.out.println();
        Jsonb jsonb = JsonbBuilder.create();
        Person person = jsonb.fromJson(jsonObject.toString(), Person.class);
        System.out.println("Name: " + person.getName());
        System.out.println("\nJava Object: \n" + person);
    }
}
