package com.jakarta.controller;

import com.jakarta.dto.Personel;
import com.jakarta.dto.Unit;
import com.jakarta.service.PersonelService;
import com.jakarta.service.UnitService;
import com.jakarta.utils.exception.ExceptionThrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class PersonelController {

    @Autowired
    private PersonelService service;

    @GetMapping(value = "/personels")
    public ResponseEntity<List<Personel>> getAll(Pageable pageable) throws ExceptionThrow {
        return new ResponseEntity<>(service.getPersonelService().findAll(pageable), HttpStatus.OK);
    }

    @PostMapping(value = "/personels")
    public ResponseEntity<Personel> create(@RequestBody Personel dto) throws ExceptionThrow{
        return new ResponseEntity<>(service.getPersonelService().create(dto),HttpStatus.CREATED);
    }

}
