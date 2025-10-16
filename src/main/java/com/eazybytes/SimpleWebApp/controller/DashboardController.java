package com.eazybytes.SimpleWebApp.controller;

import com.eazybytes.SimpleWebApp.model.Person;
import com.eazybytes.SimpleWebApp.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/dashboard")
    public String getDashboard(Model model, Authentication authentication, HttpSession session){
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if(null != person.getEazyClass() && null != person.getEazyClass().getName()){
            model.addAttribute("enrolledClass", person.getEazyClass().getName());
        }
        session.setAttribute("loggedInPerson", person);
        //throw  new RuntimeException("an error occureed");
        return "dashboard.html";
    }
}
