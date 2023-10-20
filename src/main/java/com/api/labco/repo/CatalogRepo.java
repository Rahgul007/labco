package com.api.labco.repo;

import com.api.labco.entity.Catalog;
import com.api.labco.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface CatalogRepo extends PagingAndSortingRepository<Catalog,Integer> {
    Catalog save(Catalog catalog);
    
    Page<Catalog> findAll(Pageable pageable);

    Optional<Catalog> findById(int id);

    void deleteById(int id);
}
