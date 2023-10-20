package com.api.labco.controller;

import com.api.labco.service.ApplicationService;
import com.api.labco.service.CatalogService;
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
public class CatalogController {
    @Autowired
    private Utils utils;
    @Autowired
    private CatalogService catalogService;
    @PostMapping("/catalog")
    public ResponseEntity<Object> addCatalog(@RequestParam("file") MultipartFile file, @RequestParam("title") String title) throws IOException {
        return catalogService.addNewCatalog(file,title);
    }

    @GetMapping("/catalog")
    public ResponseEntity<Object> getCatalog(@RequestParam("page") int page,@RequestParam("size") int size){
        return catalogService.getCatalogDetail(page,size);
    }
    @GetMapping("/catalog/{id}")
    public ResponseEntity<Object> getCatalogById(@PathVariable("id") int id){
        return catalogService.getCatalogDataById(id);
    }
    @DeleteMapping("/catalog/{id}")
    public ResponseEntity<Object> deleteCatalogById(@PathVariable("id") int id){
        return catalogService.deleteCatalogById(id);
    }

    @PutMapping("/catalog/{id}")
    public ResponseEntity<Object> updateCatalogById(@PathVariable("id") int id, @RequestParam("file") MultipartFile file, @RequestParam("title") String title) throws IOException{
        return catalogService.updateCatalogDataById(id,file,title);
    }

    // for serve image
    @GetMapping(value = "/image/catalog/{filename}",produces = MediaType.ALL_VALUE)
    public void getImage(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
        InputStream resource=utils.serveImage(filename);
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }
}
