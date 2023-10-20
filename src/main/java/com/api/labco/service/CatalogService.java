package com.api.labco.service;


import com.api.labco.entity.Catalog;
import com.api.labco.repo.CatalogRepo;
import com.api.labco.utils.Response;
import com.api.labco.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepo catalogRepo;
    @Autowired
    private Utils utilsD;
    public ResponseEntity<Object> addNewCatalog(MultipartFile file, String title){
        try {
            Catalog catalog=catalogRepo.save(new Catalog(title,utilsD.handleFileUpload(file,"catalog")));
            return Response.generateResponse("successfully added new data", HttpStatus.CREATED,catalog);

        }catch (IOException e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

    public ResponseEntity<Object> getCatalogDetail(int page,int size){
        try {

            Pageable pageData= PageRequest.of(page,size, Sort.by("createdAt").descending());
            Page<Catalog> catalogs = catalogRepo.findAll(pageData);

            if (!catalogs.isEmpty()){
                return Response.generateResponse("successfully all data fetched",HttpStatus.OK,catalogs);
            }
            return Response.generateResponse("No data fetched",HttpStatus.OK,catalogs);

        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

    public ResponseEntity<Object> getCatalogDataById(int id){
        try {
            Optional<Catalog> catalog=catalogRepo.findById(id);
            if (catalog.isPresent()){
                return Response.generateResponse("successfully data fetched",HttpStatus.FOUND,catalog);
            }
            return Response.generateResponse("No data fetched",HttpStatus.NOT_FOUND,catalog);
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

    public ResponseEntity<Object> deleteCatalogById(int id){
        try{
            Optional<Catalog> catalog=catalogRepo.findById(id);
            if (catalog.isPresent()){
                catalogRepo.deleteById(id);
                return Response.generateResponse("successfully data Deleted",HttpStatus.FOUND,catalog);
            }
            return Response.generateResponse("No data found",HttpStatus.NOT_FOUND,"");
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

    public ResponseEntity<Object> updateCatalogDataById(int id,MultipartFile file, String title) throws IOException{
        try {
            Optional<Catalog> catalog=catalogRepo.findById(id);
            if(catalog.isPresent()){
                Catalog _catalog=catalog.get();
                _catalog.setTitle(title);
                _catalog.setImgPath(utilsD.handleFileUpload(file,"catalog"));
                catalogRepo.save(_catalog);
                return Response.generateResponse("successfully data updated",HttpStatus.ACCEPTED,_catalog);
            }
            else {
                return Response.generateResponse("Data not found",HttpStatus.NOT_FOUND,"");
            }
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }
}
