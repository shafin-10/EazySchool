package com.example.EazySchool.Controller;

import com.example.EazySchool.Model.Contact;
import com.example.EazySchool.Service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {


    public final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact.html";
    }

   /* @PostMapping(value = "/saveMsg")
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum, @RequestParam String email,
                                    @RequestParam String subject, @RequestParam String message)
    {
        log.info("name : " + name);
        log.info("Mobile num : " + mobileNum);
        log.info("Email: " + email);
        log.info("Subject : " + subject);
        log.info("message : " + message);
        return new ModelAndView("redirect:/contact");
    }*/

    @PostMapping("/saveMsg")
    public ModelAndView saveMessage(Contact contact)
    {
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
