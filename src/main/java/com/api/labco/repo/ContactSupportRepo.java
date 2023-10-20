package com.api.labco.repo;

import com.api.labco.entity.ContactSupport;
import com.api.labco.entity.ContactSupportType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactSupportRepo extends CrudRepository<ContactSupport,Integer> {
    List<ContactSupport> findAllContactSupportByContactSupportType(ContactSupportType contactSupportType);
}

