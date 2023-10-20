package com.api.labco.service;

import com.api.labco.entity.ContactUs;
import com.api.labco.repo.ContactUsRepo;
import com.api.labco.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactUsService {
    @Autowired
    private ContactUsRepo contactUsRepo;
    public ResponseEntity<Object> addNewContactDetail(ContactUs contactUs){
       try{
           ContactUs contactUsData=contactUsRepo.save(contactUs);
           return Response.generateResponse("Successfully added new data", HttpStatus.CREATED,contactUsData);
       }catch (Exception e){
           return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
       }
    }
    public ResponseEntity<Object> getContactUsDetail(){
       try{
           List<ContactUs> contactUsList=new ArrayList<>();
           contactUsRepo.findAll().forEach(contactUsList::add);
//           System.out.println(contactUsList+"sdfsdfd");
           if (!contactUsList.isEmpty()){
               return Response.generateResponse("Successfully data fetched", HttpStatus.OK,contactUsList);
           }
           return Response.generateResponse("No data fetched", HttpStatus.OK,contactUsList);
       }catch (Exception e){
           return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
       }
    }
    public ResponseEntity<Object> getContactUsDetailById(int id){
       try{
           Optional<ContactUs> contactUs=contactUsRepo.findById(id);
           if (contactUs.isPresent()){
               return Response.generateResponse("Successfully data fetched", HttpStatus.OK,contactUs);
           }
           return Response.generateResponse("No data found", HttpStatus.OK,contactUs);
       }catch (Exception e){
           return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
       }
    }
    public ResponseEntity<Object> deleteContactUsDetailById(int id){
       try{
           Optional<ContactUs> contactUs=contactUsRepo.findById(id);
           if (contactUs.isPresent()){
               contactUsRepo.deleteById(id);
               return Response.generateResponse("Successfully data deleted", HttpStatus.OK,contactUs);
           }
           return Response.generateResponse("No data found", HttpStatus.OK,contactUs);
       }catch (Exception e){
           return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
       }
    }

     public ResponseEntity<Object> updateContactUsDetailById(int id,ContactUs data){
           try{
               Optional<ContactUs> contactUs=contactUsRepo.findById(id);
               if (contactUs.isPresent()){
                   ContactUs _contactUs=contactUs.get();
                   _contactUs.setCompany_name(data.getCompany_name());
                   _contactUs.setPhoneNumber(data.getPhoneNumber());
                   _contactUs.setMessage(data.getMessage());
                   _contactUs.setName(data.getName());
                   _contactUs.setEmail(data.getEmail());
                   contactUsRepo.save(_contactUs);
                   return Response.generateResponse("Successfully data updated", HttpStatus.OK,contactUs);
               }
               return Response.generateResponse("No data found", HttpStatus.OK,contactUs);
           }catch (Exception e){
               return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
           }
    }


}
