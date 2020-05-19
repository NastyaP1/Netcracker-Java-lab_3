package com.lab_3.springsoap.gen;

import com.lab_3.springsoap.gen.GetPersonRequest;
import com.lab_3.springsoap.gen.GetPersonResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class PersonEndPoint {
 
    public static Logger logger = LogManager.getLogger();

    private static final String NAMESPACE_URI = "http://www.lab_3.com/springsoap/gen";

    private PersonRepository personRepository;

   

    @Autowired
    public PersonEndPoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getCountry(@RequestPayload GetPersonRequest request) {
        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(personRepository.findPerson(request.getAge()));
        return response;
    }
}