package com.api.labco.service;

import com.api.labco.entity.Application;
import com.api.labco.entity.Product;
import com.api.labco.repo.ApplicationRepo;
import com.api.labco.repo.ProductRepo;
import com.api.labco.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ApplicationRepo applicationRepo;
    @Autowired
    private ProductRepo productRepo;

    public ResponseEntity<Object> addNewProductWithApplicationId(Product product){
       try{
           Application application=applicationRepo.findById(product.getApplication().getId()).orElse(null);
           if (application==null){
               return Response.generateResponse("Invalid Application Id", HttpStatus.NOT_FOUND,"");
           }
           product.setApplication(application);
           Product data=productRepo.save(product);
           return Response.generateResponse("successfully added new product", HttpStatus.CREATED,data);
       }catch (Exception e){
           return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
       }
    }

    public ResponseEntity<Object> updateProduct(int id,Product product){
        try{
            Optional<Product> data=productRepo.findById(id);
            if(data.isPresent()){
                Product _product=data.get();
                _product.setApplication(product.getApplication());
                _product.setProductNumber(product.getProductNumber());
                _product.setDescription(product.getDescription());
                _product.setDensity(product.getDensity());
                _product.setCasNumber(product.getCasNumber());
                _product.setBollingPoint(product.getBollingPoint());
                _product.setDrugPrecursor(product.getDrugPrecursor());
                _product.setDualUseMaterial(product.getDualUseMaterial());
                _product.setEinecsNo(product.getEinecsNo());
                _product.setFlashPoint(product.getFlashPoint());
                _product.setGrossWeight(product.getGrossWeight());
                _product.setMdlNumber(product.getMdlNumber());
                _product.setMolecularFormula(product.getMolecularFormula());
                _product.setNarcoticPermission(product.getNarcoticPermission());
                _product.setNetWeight(product.getNetWeight());
                _product.setPurityGrade(product.getPurityGrade());
                _product.setRadioactiveMaterial(product.getRadioactiveMaterial());
                _product.setrPhrases(product.getrPhrases());
                _product.setShippedICE(product.getShippedICE());
                _product.setSpecificActivity(product.getSpecificActivity());
                _product.setStorageTemperature(product.getStorageTemperature());
                _product.setProductNumber(product.getProductNumber());
                _product.setSynonyms(product.getSynonyms());
                _product.setTariffNumber(product.getTariffNumber());
                productRepo.save(_product);
                return Response.generateResponse("successfully updated data", HttpStatus.ACCEPTED,_product);
            }
            return Response.generateResponse("Invalid product Id", HttpStatus.NOT_FOUND,"");
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

    public ResponseEntity<Object> getAllProduct(int page,int size){
        try{
            Pageable pageData= PageRequest.of(page,size,Sort.by("createdAt").descending());
            Page<Product> product=productRepo.findAll(pageData);
            return Response.generateResponse("Successfully product fetched",HttpStatus.OK,product);
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

    public ResponseEntity<Object> searchAllProduct(String searchItem){
        try{
            List<Product> productNumber=productRepo.findProductByProductNumberLike(searchItem);
            List<Product> casNumber=productRepo.findProductByCasNumberLike(searchItem);
            if(!productNumber.isEmpty()){
                return Response.generateResponse("Successfully data fetched", HttpStatus.OK,productNumber);
            } else if (!casNumber.isEmpty()) {
                return Response.generateResponse("Successfully data fetched", HttpStatus.OK,casNumber);
            }
            return Response.generateResponse("No search result", HttpStatus.OK,"");
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }

    public ResponseEntity<Object> deleteProductById(int id){
        try{
            Optional<Product> product=productRepo.findById(id);
            if (product.isPresent()){
                productRepo.deleteById(id);
                return Response.generateResponse("Successfully Data deleted", HttpStatus.ACCEPTED,"");
            }
            return Response.generateResponse("Data not found", HttpStatus.NOT_FOUND,"");
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }


    public ResponseEntity<Object> getAllProductByApplication(int id,int page,int size){
        try{
            Optional<Application> application=applicationRepo.findById(id);
            if (application.isPresent()){
                Pageable pageData= PageRequest.of(page,size,Sort.by("createdAt").descending());
                Page<Product> productList = productRepo.findProductByApplication(application,pageData);
                return Response.generateResponse("Successfully product fetched",HttpStatus.OK,productList);
            }
            return Response.generateResponse("Invalid application ic",HttpStatus.NOT_FOUND,"");
        }catch (Exception e){
            return Response.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,e.getStackTrace());
        }
    }
}
