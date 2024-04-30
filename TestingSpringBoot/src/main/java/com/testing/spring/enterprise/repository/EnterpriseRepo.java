package com.testing.spring.enterprise.repository;
import com.testing.spring.enterprise.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepo extends JpaRepository<Enterprise, Long> { // Employee por el objecto que va a almacenar, y Long por el tipo de dato del ID
}
