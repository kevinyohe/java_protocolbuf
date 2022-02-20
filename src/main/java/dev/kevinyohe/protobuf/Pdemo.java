package dev.kevinyohe.protobuf;


import dev.kevinyohe.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pdemo {
    public static void main(String[] args) throws IOException {
        Person adf = Person.newBuilder().setAge(41).setName("Kevin").build();
        System.out.println("adf.getName() = " + adf.getName());


        // Save and then read data from a file;
        Path path = Paths.get("kevin.ser");
        Files.write(path, adf.toByteArray());


        byte[] bytes = Files.readAllBytes(path);
        Person newKevin = Person.parseFrom(bytes);
        System.out.println("newKevin.getName() = " + newKevin.getName());
        System.out.println("newKevin.getName() = " + newKevin.getAge());

    }
}
