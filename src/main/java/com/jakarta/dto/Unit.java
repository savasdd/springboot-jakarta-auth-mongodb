package com.jakarta.dto;

import com.jakarta.utils.audit.AuditMetadata;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Unit extends AuditMetadata {

    @Id
    private String id;
    private String name;
    private String kod;
    private UnitType type;
}
