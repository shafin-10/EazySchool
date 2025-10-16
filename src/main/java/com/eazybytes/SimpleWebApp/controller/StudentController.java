package com.eazybytes.SimpleWebApp.controller;

import com.eazybytes.SimpleWebApp.model.Person;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Person person = (Person) session.getAttribute("loggedInPerson");
        modelAndView.setViewName("courses_enrolled.html");
        model.addAttribute("person", person);
        return modelAndView;
    }
}
