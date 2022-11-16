package com.example.demo.Api;

import com.example.demo.Model.Person;
import com.example.demo.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void AddPerson(@Validated @NonNull @RequestBody Person person){
        personService.AddPerson(person);
    }
    @GetMapping
    public List<Person> getAllPersons (){
       return personService.getAllPeople();
    }
    @GetMapping(path ="{id}")
    public Person selectPersonById (@PathVariable("id") UUID id){
        return personService.selectPersonById(id).orElse(null);
    }

    @DeleteMapping(path ="{id}")
    public void deletePersonById (@PathVariable("id") UUID id){
         personService.deletePersonById(id);
    }
    @PutMapping(path ="{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        personService.updatePersonById(id, personToUpdate);
}
}
