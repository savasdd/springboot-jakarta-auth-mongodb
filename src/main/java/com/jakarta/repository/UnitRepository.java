package com.jakarta.repository;

import com.jakarta.dto.Unit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UnitRepository extends MongoRepository<Unit,String> {
    List<Unit> findByName(String name);
}
