package com.shopify.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopify.entity.BillDetailsEntity;

@Repository
public interface BillRepository extends JpaRepository<BillDetailsEntity, Long>{

	Optional<BillDetailsEntity> findByBilledDate(LocalDate billedDate);

}
