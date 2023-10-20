package com.api.labco.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.*;
import java.nio.file.*;

@Component
public class Utils {

    private Path fileUploadLocation=null;
    @Autowired
    private FileStorageProperty fileStorageProperty;

    public String handleFileUpload(MultipartFile file,String type) throws IOException{
//        Path fileUploadLocation= Paths.get(fileStorageProperty.getApplicationDir()).toAbsolutePath().normalize();
        String contentType=type;
        if(contentType=="application"){
            this.fileUploadLocation= Paths.get(fileStorageProperty.getApplicationDir()).toAbsolutePath().normalize();
        } else if (contentType=="catalog") {
            this.fileUploadLocation= Paths.get(fileStorageProperty.getCatalogDir()).toAbsolutePath().normalize();
        }
//        System.out.println(this.fileUploadLocation);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            Files.createDirectories(this.fileUploadLocation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path targetLocation = this.fileUploadLocation.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        String url=ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/"+contentType+"/").path(fileName).toUriString();
//        System.out.println(url+": Url");
        return url;
    }

    public InputStream serveImage(String filename) throws FileNotFoundException {
        String fullPath=this.fileUploadLocation.toString()+ File.separatorChar+filename;
        InputStream is=new FileInputStream(fullPath);
        return is;
    }
}
