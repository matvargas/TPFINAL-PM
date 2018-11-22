package com.saracurahc.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EventDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAll() {
        return jdbcTemplate.queryForList("select * from Event");
    }

    public List<Map<String, Object>> getEventsByDoctorName(String doctorName) {
        return jdbcTemplate.queryForList("select * from Event E " +
                "INNER JOIN Doctor D " +
                "ON E.doctor_associated = D.id " +
                "WHERE D.name = ?", new Object[]{doctorName});
    }

}
