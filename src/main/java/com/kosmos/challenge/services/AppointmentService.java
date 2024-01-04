package com.kosmos.challenge.services;

import static com.kosmos.challenge.specifications.AppointmentSpecifications.forDoctor;
import static com.kosmos.challenge.specifications.AppointmentSpecifications.forDoctorsOffice;
import static com.kosmos.challenge.specifications.AppointmentSpecifications.timeBetween;

import com.kosmos.challenge.entities.Appointment;
import com.kosmos.challenge.repositories.AppointmentRepository;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
  @Autowired private AppointmentRepository appointmentRepository;

  public Appointment createAppointment(Appointment appointment) {
    Calendar before = Calendar.getInstance();
    before.setTime(appointment.getTime());
    before.add(Calendar.HOUR, -1);

    Calendar after = Calendar.getInstance();
    after.setTime(appointment.getTime());
    after.add(Calendar.HOUR, 1);

    if (appointmentRepository.exists(
        timeBetween(before.getTime(), after.getTime())
            .and(forDoctorsOffice(appointment.getDoctorsOffice())))) {
      throw new RuntimeException("Este consultorio esta ocupado en el tiempo indicado");
    }

    if (appointmentRepository.exists(
        timeBetween(before.getTime(), after.getTime()).and(forDoctor(appointment.getDoctor())))) {
      throw new RuntimeException("Este doctor esta ocupado en el tiempo indicado");
    }

    return null;
  }
}
