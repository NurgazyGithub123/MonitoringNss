package com.example.monitoringNss.domain.repository;

import com.example.monitoringNss.domain.model.entity.TestClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestClassRepo extends JpaRepository<TestClassEntity, Long> {
}
