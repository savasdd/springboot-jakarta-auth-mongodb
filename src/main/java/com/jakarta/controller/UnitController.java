package com.jakarta.controller;

import com.jakarta.dto.Unit;
import com.jakarta.service.UnitService;
import com.jakarta.utils.exception.ExceptionThrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class UnitController {

    @Autowired
    private UnitService service;

    @GetMapping(value = "/units")
    public ResponseEntity<List<Unit>> getAll() throws ExceptionThrow {
        return new ResponseEntity<>(service.getUnitService().getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/units/name")
    public ResponseEntity<List<Unit>> getByName(@RequestParam("name") String name) throws ExceptionThrow{
        return new ResponseEntity<>(service.getUnitService().findByName(name), HttpStatus.OK);
    }

    @PostMapping(value = "/units")
    public ResponseEntity<Unit> create(@RequestBody Unit dto) throws ExceptionThrow{
        return new ResponseEntity<>(service.getUnitService().create(dto),HttpStatus.CREATED);
    }

    @PutMapping(value = "/units/{id}")
    public ResponseEntity<Unit> update(@PathVariable String id,@RequestBody Unit dto) throws ExceptionThrow{
        return new ResponseEntity<>(service.getUnitService().update(id,dto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/units/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) throws ExceptionThrow{
        service.getUnitService().delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
