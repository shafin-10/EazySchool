package com.eazybytes.SimpleWebApp.service;

import com.eazybytes.SimpleWebApp.constants.EazySchoolConstants;
import com.eazybytes.SimpleWebApp.model.Contact;
import com.eazybytes.SimpleWebApp.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
//@RequestScope
//@SessionScope
//@ApplicationScope
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

   /* private int counter = 0;

    public ContactService(){
        System.out.println("Contact service Bean initialized");
    }*/


    public boolean saveMsgDetails(Contact contact){
       boolean isSaved = false;
       contact.setStatus(EazySchoolConstants.OPEN);
       //contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
       //contact.setCreatedAt(LocalDateTime.now());
      // int result = contactRepository.saveContactMsg(contact);
        Contact savedContact = contactRepository.save(contact);
       if(savedContact != null && savedContact.getContactId() > 0){
           isSaved = true;
       }
       return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum,String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatus(
                EazySchoolConstants.OPEN,pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId) {
       boolean isUpdated = false;
      // int result = contactRepository.updateMsgStatus(contactId, EazySchoolConstants.Close, updatedBy);
        Optional<Contact> contact = contactRepository.findById(contactId);

       contact.ifPresent(contact1 -> {
           contact1.setStatus(EazySchoolConstants.Close);
          // contact1.setUpdatedBy(updatedBy);
          // contact1.setUpdatedAt(LocalDateTime.now());
       });
    Contact updatedContact = contactRepository.save(contact.get());
       if(updatedContact != null && updatedContact.getUpdatedBy() != null){
           isUpdated = true;
       }
       return isUpdated;
    }






































    /*public int getCounter(){
        return counter;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }*/
}
