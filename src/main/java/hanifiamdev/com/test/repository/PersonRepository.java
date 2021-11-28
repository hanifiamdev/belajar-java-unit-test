package hanifiamdev.com.test.repository;

import hanifiamdev.com.test.data.Person;

public interface PersonRepository {

    Person selectById(String id);

    void insert(Person person);
}
