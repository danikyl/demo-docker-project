package com.danielsoftware.aplication.repository;

import com.danielsoftware.aplication.domain.model.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Integer> {
    Status findByName(String name);
}
