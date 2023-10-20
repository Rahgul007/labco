package com.api.labco.service;

import com.api.labco.entity.Application;
import com.api.labco.entity.Product;
import com.api.labco.repo.ApplicationRepo;
import com.api.labco.utils.Response;
import com.api.labco.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;


@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepo applicationRepo;
    @Autowired
    private Utils utilsD;

    public ResponseEntity<Object> addNewApplicationDetail(MultipartFile file, String title, String description) {
       try {
           Application application=applicationRepo.save(new Application(title,utilsD.handleFileUpload(file,"application"),description));
           return Response.generateResponse("successfully added new data", HttpStatus.CREATED,application);
       }catch (IOException e){
           return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
       }
    }

    public ResponseEntity<Object> getApplicationDetail(){
        try {
            List<Application> applications = new ArrayList<>();
            applicationRepo.findAll().forEach(applications::add);
            if(!applications.isEmpty()){
                return Response.generateResponse("successfully all data fetched",HttpStatus.OK,applications);
            }
            return Response.generateResponse("No data found",HttpStatus.OK,applications);
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

    public ResponseEntity<Object> getApplicationDataById(int id){
        try {
            Optional<Application> application=applicationRepo.findById(id);
            if (application.isPresent()){
                return Response.generateResponse("successfully data fetched",HttpStatus.FOUND,application);
            }
            return Response.generateResponse("No data fetched",HttpStatus.NOT_FOUND,application);
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

    public ResponseEntity<Object> deleteApplicationById(int id){
       try{
           Optional<Application> application=applicationRepo.findById(id);
           if (application.isPresent()){
               applicationRepo.deleteById(id);
               return Response.generateResponse("successfully data Deleted",HttpStatus.FOUND,application);
           }
           return Response.generateResponse("No data found",HttpStatus.NOT_FOUND,"");
       }catch (Exception e){
           return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
       }
    }

    public ResponseEntity<Object> updateApplicationDataById(int id,MultipartFile file, String title, String description) throws IOException{
       try {
           Optional<Application> application=applicationRepo.findById(id);
           if(application.isPresent()){
               Application _application=application.get();
               _application.setTitle(title);
               _application.setImgPath(utilsD.handleFileUpload(file,"application"));
               _application.setDescription(description);
               applicationRepo.save(_application);
               return Response.generateResponse("successfully data updated",HttpStatus.ACCEPTED,_application);
           }
           else {
               return Response.generateResponse("Data not found",HttpStatus.NOT_FOUND,"");
           }
       }catch (Exception e){
           return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
       }
    }

}
