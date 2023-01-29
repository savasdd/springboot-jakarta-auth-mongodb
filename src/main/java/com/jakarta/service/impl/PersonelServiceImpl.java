package com.jakarta.service.impl;

import com.jakarta.dto.Personel;
import com.jakarta.repository.PersonelRepository;
import com.jakarta.repository.UnitRepository;
import com.jakarta.utils.exception.ExceptionThrow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonelServiceImpl {

    private final PersonelRepository repository;
    private final UnitRepository unitRepository;

    public List<Personel> findAll(Pageable pageable) throws ExceptionThrow {
        return repository.findAll(pageable).getContent();
    }

    public Personel create(Personel dto) throws ExceptionThrow{
        if(dto.getUnit()==null)
            throw new ExceptionThrow("Personel Unit is Null!");

        var unit=unitRepository.findById(dto.getUnit().getId());
        if(unit.isEmpty())
            throw new ExceptionThrow("Unit is not found!");

        Personel personel=new Personel();
        personel.setName(dto.getName());
        personel.setSurname(dto.getSurname());
        personel.setUnit(unit.get());
        var newPers=repository.save(personel);
        log.info("Create Personel: "+newPers.getId());
        return newPers;
    }

}
