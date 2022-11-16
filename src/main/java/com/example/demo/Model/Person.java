package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class Person {
    private final UUID Id;
    @NonNull
    private final String Name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name")String name) {
        this.Id = id;
        this.Name = name;
    }

    public UUID getId() {
        return Id;
    }
    public String getName(){
        return Name;
    }
}
