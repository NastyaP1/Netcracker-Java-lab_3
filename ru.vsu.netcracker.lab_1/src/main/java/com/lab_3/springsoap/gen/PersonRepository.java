
package com.lab_3.springsoap.gen;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.lab_3.springsoap.gen.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Component;

@Component
public class PersonRepository {
    public static Logger logger = LogManager.getLogger(PersonRepository.class.getName());
    private static final Map<Integer, Person> people = new HashMap<>();
 
    @PostConstruct
    public void initData() {
    }
 
    public Person findPerson(Integer id) {
        if(people.get(id) != null){
            logger.error("Person hasn't been found");
        }

        else{
            logger.info("Person has been found");
        }
        return people.get(id);
    }
}