package com.boott.boott;

import com.boott.boott.entities.People;
import com.boott.boott.repository.PeopleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DatabaseInteractionTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void findsUserByEmail() {
        People people = new People();
        people.setId(1);
        people.setJobTitle("title");
        people.setFullName("name");
        entityManager.persist(people);
        assertEquals(people, peopleRepository.findById(1).orElse(null));
    }
}