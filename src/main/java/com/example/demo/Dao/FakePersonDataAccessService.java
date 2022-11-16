package com.example.demo.Dao;

import com.example.demo.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakeDao")
public class FakePersonDataAccessService implements PersonDao{
    private static List<Person> DB = new ArrayList<>();
    @Override
    public int InsertPerson(UUID Id, Person person) {
        DB.add(new Person(
                Id, person.getName()));
        return 1;
    }
    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMayBe = selectPersonById(id);
        if(personMayBe.isEmpty()){
            return 0;
        }else{
            DB.remove(personMayBe.get());
            return 1;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person updatePerson) {
    return selectPersonById(id).map(Person ->{
            int indexOfPersonToUpdate = DB.indexOf(Person);
            if(indexOfPersonToUpdate >= 0){
                DB.set(indexOfPersonToUpdate, new Person(id, updatePerson.getName()));
                return 1;
            }
            return 0;
           }).orElse(null);
    }
}
