package com.accela;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.accela.controllers.PersonController;
import com.accela.entities.Person;
import com.accela.repositories.PersonRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class PersonControllerUnitTest {
	
	private static PersonController personController;
    private static PersonRepository mockedPersonRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeAll
    public static void setUp() {
    	mockedPersonRepository = mock(PersonRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        personController = new PersonController(mockedPersonRepository);
    }

    @Test
    public void showPersonListTest() {
        assertThat(personController.showPersonList(mockedModel)).isEqualTo("index");
    }
    
    @Test
    public void SignUpFormTest() {
        Person person = new Person("Prashant", "Aggarwal");

        assertThat(personController.showSignUpForm(person)).isEqualTo("add-person");
    }
    
    @Test
    public void AddValidPersonTest() {
        Person person = new Person("Liam", "Neeson");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(personController.addPerson(person, mockedBindingResult, mockedModel)).isEqualTo("redirect:/index");
    }

    @Test
    public void AddInValidPersonTest() {
        Person person = new Person("Josh", "Carthy");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(personController.addPerson(person, mockedBindingResult, mockedModel)).isEqualTo("add-person");
    }

    @Test
    public void validEditPersonTest() {
        Person person = new Person("Tara", "Long");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(personController.updatePerson(1, person, mockedBindingResult, mockedModel)).isEqualTo("redirect:/index");
    }

    @Test
    public void InvalidPersonEditTest() {
        Person person = new Person("Mary", "Iverson");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(personController.updatePerson(1, person, mockedBindingResult, mockedModel)).isEqualTo("update-person");
    }
    
   /* @Test
    public void deletePersonTest() {
    	
    	Assertions.assertThrows(IllegalArgumentException.class, () -> personController.deletePerson(1, mockedModel));
    	
    	Person person = new Person("Prashant", "Aggarwal");
    	personController.addPerson(person, mockedBindingResult, mockedModel);
    	
        assertThat(personController.deletePerson(1, mockedModel)).isEqualTo("redirect:/index");
    }*/

}
