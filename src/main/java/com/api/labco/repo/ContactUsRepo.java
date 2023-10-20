package com.api.labco.repo;

import com.api.labco.entity.ContactUs;
import com.api.labco.entity.ContactSupportType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactUsRepo extends CrudRepository<ContactUs, Integer> {
}
