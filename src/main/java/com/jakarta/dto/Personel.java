package com.jakarta.dto;

import com.jakarta.utils.audit.AuditMetadata;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Personel extends AuditMetadata {

    @Id
    private String id;
    private String name;
    private String surname;
    private Unit unit;
}
