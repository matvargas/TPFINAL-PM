package com.saracurahc.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SpecialityDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAll() {
        return jdbcTemplate.queryForList("select * from Speciality");
    }
}
