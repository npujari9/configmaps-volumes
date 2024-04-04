package com.example.configmaps.controller;

import com.example.configmaps.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public String getDepartments() {
        log.info("Getting All Departments from Controller");
        return departmentService.getDepartments();
    }
}
