package org.javaturk.json.objectModel;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JsonBuilder {

    public static void main(String[] args) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        JsonObject jsonObject = builder.add("Name", "Jason Mason")
                .add("Profession", "Java Developer").add("Age", "28").build();

        Jsonb jsonb = JsonbBuilder.create();

        System.out.println("JSON Object: \n" + jsonb.toJson(jsonObject));
    }
}
