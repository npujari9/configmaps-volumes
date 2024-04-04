package com.example.configmaps.service;

import com.example.configmaps.respository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public String getDepartments() {
        log.info("Getting departments from service");
        return "Departments :: " + departmentRepository.getDepartments();
    }

}
