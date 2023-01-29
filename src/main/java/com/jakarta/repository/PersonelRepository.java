package com.jakarta.repository;

import com.jakarta.dto.Personel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonelRepository extends MongoRepository<Personel,String> {
}
