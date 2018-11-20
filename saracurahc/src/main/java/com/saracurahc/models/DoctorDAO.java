package com.saracurahc.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DoctorDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> findBySpeciality(String speciality) {
        return jdbcTemplate.queryForList("SELECT * FROM DOCTOR D WHERE D.speciality = ?", new Object[]{speciality});
    }

}
