package hanifiamdev.com.test.service;

import hanifiamdev.com.test.data.Person;
import hanifiamdev.com.test.repository.PersonRepository;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(String id) {
        Person person = personRepository.selectById(id);
        if(person != null) {
            return person;
        } else {
            throw new IllegalArgumentException("Person not found");
        }
    }
}
