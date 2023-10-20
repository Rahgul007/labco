package com.api.labco.repo;

import com.api.labco.entity.Application;
import com.api.labco.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findProductByProductNumberLike(String searchItem);
    List<Product> findProductByCasNumberLike(String searchItem);

    Page<Product> findProductByApplication(Optional<Application> application, Pageable pageData);

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(int id);

    Product save(Product product);

    void deleteById(int id);

}
