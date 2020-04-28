package com.spring.ssm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ssm.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
