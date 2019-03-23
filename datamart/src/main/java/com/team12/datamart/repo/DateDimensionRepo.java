package com.team12.datamart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team12.datamart.domain.DateDimension;

@Repository
public interface DateDimensionRepo extends JpaRepository<DateDimension, Integer> {

}
