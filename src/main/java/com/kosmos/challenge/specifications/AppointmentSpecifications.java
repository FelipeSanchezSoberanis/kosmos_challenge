package com.kosmos.challenge.specifications;

import com.kosmos.challenge.entities.Appointment;
import com.kosmos.challenge.entities.Doctor;
import com.kosmos.challenge.entities.DoctorsOffice;
import jakarta.persistence.criteria.Predicate;
import java.util.Date;
import org.springframework.data.jpa.domain.Specification;

public class AppointmentSpecifications {
  public static Specification<Appointment> timeBetween(Date start, Date end) {
    return (root, query, criteriaBuilder) -> {
      Predicate timeAfterStart = criteriaBuilder.greaterThanOrEqualTo(root.get("time"), start);
      Predicate timeBeforeEnd = criteriaBuilder.lessThanOrEqualTo(root.get("time"), end);
      return criteriaBuilder.and(timeAfterStart, timeBeforeEnd);
    };
  }

  public static Specification<Appointment> forDoctorsOffice(DoctorsOffice doctorsOffice) {
    return (root, query, criteriaBuilder) -> {
      return criteriaBuilder.equal(root.get("doctorsOffice"), doctorsOffice);
    };
  }

  public static Specification<Appointment> forDoctor(Doctor doctor) {
    return (root, query, criteriaBuilder) -> {
      return criteriaBuilder.equal(root.get("doctor"), doctor);
    };
  }
}
