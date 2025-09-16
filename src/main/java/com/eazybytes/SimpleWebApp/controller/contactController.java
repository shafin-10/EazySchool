package com.eazybytes.SimpleWebApp.controller;

import com.eazybytes.SimpleWebApp.model.Contact;
import com.eazybytes.SimpleWebApp.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class contactController {


    @Autowired
    public ContactService contactService;

    @GetMapping("/contact")
    public String displayContactPage(Model model){
        model.addAttribute("contact", new Contact());
        return "contact";
    }


    @PostMapping("/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("Contact from validation failed due to : " + errors.toString());
            return "contact";
        }
        contactService.saveMsgDetails(contact);
        /*contactService.setCounter(contactService.getCounter()+1);
        log.info("Number of times the Contact form is submitted : "+contactService.getCounter());*/
        return "redirect:/contact";
    }

    @GetMapping("/displayMessages")
    public ModelAndView displayMessages(Model model){
        List<Contact> contactMsgs = contactService.findMsgsWithOpebStatus();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("messages.html");
        modelAndView.addObject("contactMsgs", contactMsgs);
        return modelAndView;

    }

    @GetMapping("/closeMsg")
    public String closeMsg(@RequestParam int id, Authentication authentication){
        contactService.updateMsgStatus(id, authentication.getName());
        return "redirect:/displayMessages";
    }
}
