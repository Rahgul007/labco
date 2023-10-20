package com.api.labco.repo;

import com.api.labco.entity.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends CrudRepository<Application, Integer> {

}
