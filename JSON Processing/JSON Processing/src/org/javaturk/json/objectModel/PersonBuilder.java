package org.javaturk.json.objectModel;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.javaturk.json.bean.Person;

public class PersonBuilder {

    public static void main(String[] args) {
        JsonObject personObject = buildPerson1();
        
        Jsonb jsonb = JsonbBuilder.create();
        Person person = jsonb.fromJson(personObject.toString(), Person.class);
        System.out.println("\nJava Object: \n" + person);
    }

    public static JsonObject buildPerson1() {
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
        return jsonObject;
    }
    
    public static JsonObject buildPerson2() {
        JsonObjectBuilder builder = Json.createObjectBuilder().add("id", 22).add("name", "Jason Mason").add("permanent", true).add("sex", "Male");

        JsonArrayBuilder phoneNumBuilder = Json.createArrayBuilder().add(1234567890L).add(9876543210L).add(1122334455L);
        builder.add("phoneNumbers", phoneNumBuilder);

        JsonObjectBuilder addressBuilder = Json.createObjectBuilder().add("street", "vatan Cad. No 55/3").add("city", "Istanbul").add("zipcode", "34664");
        builder.add("address", addressBuilder);

        JsonObject jsonObject = builder.build();
        System.out.println("JSON Object: \n" + jsonObject);
        return jsonObject;
    }
}
