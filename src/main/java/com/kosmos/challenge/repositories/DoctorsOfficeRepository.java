package com.kosmos.challenge.repositories;

import com.kosmos.challenge.entities.DoctorsOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsOfficeRepository extends JpaRepository<DoctorsOffice, Long> {}
