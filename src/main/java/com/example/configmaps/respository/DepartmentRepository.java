package com.example.configmaps.respository;

import com.example.configmaps.domain.Departments;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Repository
public class DepartmentRepository {

    private final NamedParameterJdbcTemplate departmentJdbcTemplate;

    public String getDepartments() {
        List<Departments> departmentsList = departmentJdbcTemplate.query("SELECT * FROM department", BeanPropertyRowMapper.newInstance(Departments.class));
        List<String> departmentNames = departmentsList.stream().map(Departments::getName).collect(Collectors.toList());
        log.info("Departments Size: {}", departmentNames.size());
        return String.join(",  ", departmentNames);
    }

}
