package com.api.labco.controller;

import com.api.labco.entity.ContactSupport;
import com.api.labco.entity.ContactSupportType;
import com.api.labco.service.ContactSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactSupportController {

    @Autowired
    private ContactSupportService contactSupportService;
    @PostMapping("/contact-support")
    public ResponseEntity<Object> addNewContactSupport(@RequestBody ContactSupport contactSupport){
        return contactSupportService.addNewContactSupportDetail(contactSupport);
    }
    @GetMapping("/contact-support/{contactSupportType}")
    public ResponseEntity<Object> getContactSupport(@PathVariable("contactSupportType")ContactSupportType contactSupportType){
        return contactSupportService.getContactSupportDetail(contactSupportType);
    }
    @PutMapping("/contact-support/{id}")
    public ResponseEntity<Object> updateContactSupport(@PathVariable("id") int id,@RequestBody ContactSupport contactSupport){
        return contactSupportService.updateContactSupportDetailById(id,contactSupport);
    }
    @GetMapping("/contact-support/{id}")
    public ResponseEntity<Object> getContactSupportById(@PathVariable("id") int id){
        return contactSupportService.getContactSupportDetailById(id);
    }
    @DeleteMapping("/contact-support/{id}")
    public ResponseEntity<Object> deleteContactSupportById(@PathVariable("id") int id){
        return contactSupportService.deleteContactSupportDetailById(id);
    }

}
