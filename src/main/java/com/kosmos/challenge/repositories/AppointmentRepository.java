package com.kosmos.challenge.repositories;

import com.kosmos.challenge.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AppointmentRepository
    extends JpaRepository<Appointment, Long>, JpaSpecificationExecutor<Appointment> {}
