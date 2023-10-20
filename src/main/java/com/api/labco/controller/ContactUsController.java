package com.api.labco.controller;

import com.api.labco.entity.ContactUs;
import com.api.labco.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactUsController {
    @Autowired
    private ContactUsService contactUsService;

    @PostMapping("/contact-us")
    public ResponseEntity<Object> addNewContactUs(@RequestBody ContactUs contactUs){
        return contactUsService.addNewContactDetail(contactUs);
    }
    @GetMapping("/contact-us")
    public ResponseEntity<Object> getContactUs(){
        return contactUsService.getContactUsDetail();
    }
    @PutMapping("/contact-us/{id}")
    public ResponseEntity<Object> updateContactUs(@PathVariable("id") int id,@RequestBody ContactUs contactUs){
        return contactUsService.updateContactUsDetailById(id,contactUs);
    }
    @GetMapping("/contact-us/{id}")
    public ResponseEntity<Object> getContactUsById(@PathVariable("id") int id){
        return contactUsService.getContactUsDetailById(id);
    }
    @DeleteMapping("/contact-us/{id}")
    public ResponseEntity<Object> deleteContactUsById(@PathVariable("id") int id){
        return contactUsService.deleteContactUsDetailById(id);
    }


}
