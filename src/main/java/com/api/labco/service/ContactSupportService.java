package com.api.labco.service;

import com.api.labco.entity.ContactSupport;
import com.api.labco.entity.ContactSupportType;
import com.api.labco.entity.ContactUs;
import com.api.labco.repo.ContactSupportRepo;
import com.api.labco.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactSupportService {
    @Autowired
    private ContactSupportRepo contactSupportRepo;

    public ResponseEntity<Object> addNewContactSupportDetail(ContactSupport contactSupport){
        try{
            ContactSupport contactSupportData=contactSupportRepo.save(contactSupport);
            return Response.generateResponse("Successfully added new data", HttpStatus.CREATED,contactSupportData);
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }
    public ResponseEntity<Object> getContactSupportDetail(ContactSupportType contactSupportType){
        try{
            List<ContactSupport> contactSupportList=new ArrayList<>();
            contactSupportRepo.findAllContactSupportByContactSupportType(contactSupportType).forEach(contactSupportList::add);
            if (!contactSupportList.isEmpty()){
                return Response.generateResponse("Successfully data fetched", HttpStatus.OK,contactSupportList);
            }
            return Response.generateResponse("No data fetched", HttpStatus.OK,contactSupportList);
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }
    public ResponseEntity<Object> getContactSupportDetailById(int id){
        try{
            Optional<ContactSupport> contactSupport=contactSupportRepo.findById(id);
            if (contactSupport.isPresent()){
                return Response.generateResponse("Successfully data fetched", HttpStatus.OK,contactSupport);
            }
            return Response.generateResponse("No data found", HttpStatus.OK,contactSupport);
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }
    public ResponseEntity<Object> deleteContactSupportDetailById(int id){
        try{
            Optional<ContactSupport> contactSupport=contactSupportRepo.findById(id);
            if (contactSupport.isPresent()){
                contactSupportRepo.deleteById(id);
                return Response.generateResponse("Successfully data deleted", HttpStatus.OK,contactSupport);
            }
            return Response.generateResponse("No data found", HttpStatus.OK,contactSupport);
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

    public ResponseEntity<Object> updateContactSupportDetailById(int id,ContactSupport data){
        try{
            Optional<ContactSupport> contactSupport=contactSupportRepo.findById(id);
            if (contactSupport.isPresent()){
                ContactSupport _contactSupport=contactSupport.get();
                _contactSupport.setEmail(data.getEmail());
                _contactSupport.setContactSupportType(data.getContactSupportType());
                _contactSupport.setAddress(data.getAddress());
                _contactSupport.setFaxNumber(data.getFaxNumber());
                _contactSupport.setTelephoneNumber(data.getTelephoneNumber());
                _contactSupport.setWebsiteUrl(data.getWebsiteUrl());
                contactSupportRepo.save(_contactSupport);
                return Response.generateResponse("Successfully data updated", HttpStatus.OK,contactSupport);
            }
            return Response.generateResponse("No data found", HttpStatus.OK,contactSupport);
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

}
