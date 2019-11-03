package com.surafel.batch.repository;

import com.surafel.batch.model.TransformedStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<TransformedStudent, Integer> {
}
