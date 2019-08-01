package com.educandoweb.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.workshop.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
