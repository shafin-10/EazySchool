package com.eazybytes.SimpleWebApp.repository;

import com.eazybytes.SimpleWebApp.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday, String>{




//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public List<Holiday> findAllHolidays(){
//        String sql = "SELECT * FROM HOLIDAYS";
//        var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
//        return jdbcTemplate.query(sql, rowMapper);
//    }

}
