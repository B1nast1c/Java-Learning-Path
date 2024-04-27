package com.example.mainunser.repository;

import com.example.mainunser.entity.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainUserRepo extends JpaRepository<MainUser, Long> { // Employee por el objecto que va a almacenar, y Long por el tipo de dato del ID
}
