package com.example.demo.Services;

import com.example.demo.Dao.PersonDao;
import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;
    @Autowired
    public PersonService(@Qualifier("Postgres") PersonDao personDao){

        this.personDao = personDao;
    }

    public int AddPerson(Person person){

        return personDao.InsertPerson(person);
    }
    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
    public Optional<Person> selectPersonById (UUID id){
        return personDao.selectPersonById(id);
    }
    public int deletePersonById (UUID id){
        return personDao.deletePersonById(id);
    }
    public int updatePersonById (UUID id,Person person ){
        return personDao.updatePersonById(id, person);
    }
}
