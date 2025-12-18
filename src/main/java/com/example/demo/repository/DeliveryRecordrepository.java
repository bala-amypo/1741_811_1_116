package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DeliveryRecord;

public interface DeliveryRecordrepository extends JpaRepository<DeliveryRecord , Long>{

}
