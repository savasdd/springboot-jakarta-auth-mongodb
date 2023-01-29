package com.jakarta.service.impl;

import com.jakarta.dto.Unit;
import com.jakarta.repository.UnitRepository;
import com.jakarta.utils.exception.ExceptionThrow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UnitServiceImpl {

    @Autowired
    private UnitRepository repository;

    public List<Unit> getAll() throws ExceptionThrow {
        var list=repository.findAll();
        log.info("Get All Unit: "+list.size());
        return list;
    }

    public List<Unit> findByName(String name) throws ExceptionThrow{
        var unit=repository.findByName(name);
        return unit;
    }

    public Unit create(Unit dto) throws ExceptionThrow{
        Unit unit=new Unit();
        unit.setName(dto.getName());
        unit.setKod(dto.getKod());
        unit.setType(dto.getType());
        var newUnit=repository.save(unit);
        log.info("Create unit: "+newUnit.getId());

        return newUnit;
    }

    public Unit update(String id,Unit dto) throws ExceptionThrow{
        var units=repository.findById(id);
        var updateUnit=units.map(val->{
           val.setName(dto.getName());
           val.setKod(dto.getKod());
           val.setType(dto.getType());
            return val;
        });
        var newUnit=repository.save(updateUnit.get());
        log.info("Update Unit: "+dto.getId());
        return newUnit;
    }

    public void delete(String id) throws ExceptionThrow{
        repository.deleteById(id);
        log.info("Delete Unit: "+id);
    }
}
