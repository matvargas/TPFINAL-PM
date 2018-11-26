package com.saracurahc.models;

import com.saracurahc.Objects.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean insertOrUpdatePatient(Patient patient) {

        boolean response = false;
        int responseInt = jdbcTemplate.update("INSERT INTO PATIENT(name, phone) VALUES(?,?)",
                patient.getName(),
                patient.getPhoneNumber());

        if(responseInt == 1) {
            response = true;
        }

        return response;
    }


}
