package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.generalAssert;


@SuppressWarnings("rawtypes")
@Repository
public interface AssertRepository extends JpaRepository<generalAssert, Long>{

}
