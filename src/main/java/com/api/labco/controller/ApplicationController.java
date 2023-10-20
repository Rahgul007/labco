package com.api.labco.controller;


import com.api.labco.service.ApplicationService;
import com.api.labco.utils.Utils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class ApplicationController {

    @Autowired
    private Utils utils;
    @Autowired
    private ApplicationService applicationService;
    @PostMapping("/application")
    public ResponseEntity<Object> addApplication(@RequestParam("file") MultipartFile file, @RequestParam("title") String title, @RequestParam("description") String description) throws IOException {
       return applicationService.addNewApplicationDetail(file,title,description);
    }

    @GetMapping("/application")
    public ResponseEntity<Object> getApplication(){
        return applicationService.getApplicationDetail();
    }
    @GetMapping("/application/{id}")
    public ResponseEntity<Object> getApplicationById(@PathVariable("id") int id){
        return applicationService.getApplicationDataById(id);
    }
    @DeleteMapping("/application/{id}")
    public ResponseEntity<Object> deleteApplicationById(@PathVariable("id") int id){
        return applicationService.deleteApplicationById(id);
    }

    @PutMapping("/application/{id}")
    public ResponseEntity<Object> updateApplicationById(@PathVariable("id") int id, @RequestParam("file") MultipartFile file, @RequestParam("title") String title, @RequestParam("description") String description) throws IOException{
        return applicationService.updateApplicationDataById(id,file,title,description);
    }

    // for serve image
    @GetMapping(value = "/image/application/{filename}",produces = MediaType.ALL_VALUE)
    public void getImage(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
        InputStream resource=utils.serveImage(filename);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }
}
