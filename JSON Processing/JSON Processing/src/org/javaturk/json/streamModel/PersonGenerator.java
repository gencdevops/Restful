package org.javaturk.json.streamModel;

import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class PersonGenerator {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("/Users/akin/Java/Eclipse/202009/workspace/JSON Processing/src/resource/person_new2.json");
        JsonGenerator gen = Json.createGenerator(writer);
        gen.writeStartObject()
           .write("id", 22)
           .write("name", "John Flier")
           .write("permanent", true)
               
           .writeStartObject("Address")
               .write("street", "Vatan Cad. No 55/3")
               .write("city", "Istanbul")
               .write("zipcode", "34664")
           .writeEnd()
           
           .writeStartArray("phoneNumbers")
               .write(1234567890L)
               .write(9876543210L)
           .writeEnd()
       
           .write("sex", "Male")
        .writeEnd();
        gen.close();
    }
}
