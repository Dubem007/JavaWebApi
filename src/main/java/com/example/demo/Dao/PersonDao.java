package com.example.demo.Dao;

import com.example.demo.Model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int InsertPerson(UUID Id, Person person);
    default int InsertPerson(Person person){
        UUID Id = UUID.randomUUID();
        return InsertPerson(Id, person);
    }
    List<Person> selectAllPeople();
    Optional<Person> selectPersonById(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
}
