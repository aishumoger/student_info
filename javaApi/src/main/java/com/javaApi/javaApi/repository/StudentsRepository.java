package com.javaApi.javaApi.repository;

import com.javaApi.javaApi.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

}
