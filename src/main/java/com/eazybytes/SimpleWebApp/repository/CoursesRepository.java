package com.eazybytes.SimpleWebApp.repository;

import com.eazybytes.SimpleWebApp.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Integer> {
    /*
   Spring Data JPA allows us to apply static sorting by adding the OrderBy keyword
   to the method name along with the property name and sort direction (Asc or Desc).
   * */
    List<Courses> findByOrderByNameDesc();

    /*
    The Asc keyword is optional as OrderBy, by default,
    sorts the results in the ascending order.
    * */
    List<Courses> findByOrderByName();
}
