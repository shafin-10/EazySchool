package com.eazybytes.SimpleWebApp.repository;

import com.eazybytes.SimpleWebApp.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass, Integer> {
}
