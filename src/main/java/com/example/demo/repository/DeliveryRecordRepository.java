package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DeliveryRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRecordrepository extends JpaRepository<DeliveryRecord , Long>{

    DeliveryRecord findByContractId(Long contractId);

}
