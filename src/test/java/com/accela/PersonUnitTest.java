package com.accela;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.accela.entities.Person;

@SpringBootTest
public class PersonUnitTest {
	
	@Test
    public void testFirstName() {
        Person user = new Person("Prashant", "Aggarwal");
        
        assertEquals(user.getFname(), "Prashant");
    }
	
	@Test
    public void testLastName() {
        Person user = new Person("Prashant", "Aggarwal");
        
        assertEquals(user.getLname(), "Aggarwal");
    }
	
	@Test
    public void setFirstName() {
        Person person = new Person("John", "Connor");
        
        person.setFname("Adam");
        
        assertEquals(person.getFname(),"Adam");
    }
    
    @Test
    public void setLastName() {
        Person person = new Person("William", "Fadian");
        
        person.setLname("Harrington");
        
        assertEquals(person.getLname(),"Harrington");
    }
    
    @Test
    public void testToString() {
        Person person = new Person("Sufiya", "Karim");
        assertEquals(person.toString(),"Person{id=null, fname=Sufiya, lname=Karim}");
    }

}
