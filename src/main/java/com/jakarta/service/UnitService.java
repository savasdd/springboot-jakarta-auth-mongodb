package com.jakarta.service;

import com.jakarta.service.impl.UnitServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class UnitService {

    private final UnitServiceImpl unitService;
}
