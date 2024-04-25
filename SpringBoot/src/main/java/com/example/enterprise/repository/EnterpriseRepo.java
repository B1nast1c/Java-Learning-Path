package com.example.enterprise.repository;

import com.example.enterprise.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepo extends JpaRepository<Enterprise, Long> { // Employee por el objecto que va a almacenar, y Long por el tipo de dato del ID
}
