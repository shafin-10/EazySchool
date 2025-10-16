package com.eazybytes.SimpleWebApp.repository;

import com.eazybytes.SimpleWebApp.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Integer> {
}
