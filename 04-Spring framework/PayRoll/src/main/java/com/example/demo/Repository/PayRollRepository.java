package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PayRollmodel;

@Repository
public interface PayRollRepository extends JpaRepository<PayRollmodel,Long> {

}
