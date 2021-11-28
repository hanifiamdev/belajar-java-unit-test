package hanifiamdev.com.test.service;


import hanifiamdev.com.test.data.Person;
import hanifiamdev.com.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // menambah behavior ke mock object
        Mockito.when(personRepository.selectById("hanif")).thenReturn(new Person("hanif", "Hanif"));
        var person = personService.get("hanif");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("hanif", person.getId());
        Assertions.assertEquals("Hanif", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Hanif");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Hanif", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Hanif"));

    }
}
