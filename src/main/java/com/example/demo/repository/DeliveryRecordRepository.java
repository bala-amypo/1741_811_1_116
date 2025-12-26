package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DeliveryRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRecordRepository extends JpaRepository<DeliveryRecord , Long>{

    List<DeliveryRecord> findAllByContractId(Long contractId);

    DeliveryRecord findByContractId(Long contractId);

    DeliveryRecord findTopByContractIdOrderByDeliveryDateDesc(Long contractId);

    java.util.Optional<DeliveryRecord> findFirstByContractIdOrderByDeliveryDateDesc(Long contractId);

    java.util.List<DeliveryRecord> findByContractIdOrderByDeliveryDateAsc(Long contractId);

}
