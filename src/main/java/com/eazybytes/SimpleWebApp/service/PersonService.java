package com.eazybytes.SimpleWebApp.service;

import com.eazybytes.SimpleWebApp.constants.EazySchoolConstants;
import com.eazybytes.SimpleWebApp.model.Person;
import com.eazybytes.SimpleWebApp.model.Roles;
import com.eazybytes.SimpleWebApp.repository.PersonRepository;
import com.eazybytes.SimpleWebApp.repository.RolesRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person) {
        boolean isSaved = true;
        Roles role = rolesRepository.findByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if(null != person && person.getId() > 0){
            isSaved = true;
        }
        return isSaved;
    }
}
