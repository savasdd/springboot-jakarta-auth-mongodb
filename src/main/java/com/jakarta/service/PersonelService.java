package com.jakarta.service;

import com.jakarta.service.impl.PersonelServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class PersonelService {

    private final PersonelServiceImpl personelService;
}
