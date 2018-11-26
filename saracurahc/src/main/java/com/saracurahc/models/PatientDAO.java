package com.saracurahc.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PatientDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> insertOrUpdatePatient(String speciality) {
        return jdbcTemplate.queryForList("SELECT * FROM DOCTOR D WHERE D.speciality = ?", new Object[]{speciality});
    }


}
