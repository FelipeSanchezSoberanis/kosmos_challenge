package com.kosmos.challenge.controllers;

import com.kosmos.challenge.entities.Appointment;
import com.kosmos.challenge.repositories.DoctorRepository;
import com.kosmos.challenge.repositories.DoctorsOfficeRepository;
import com.kosmos.challenge.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
  @Autowired private DoctorRepository doctorRepository;
  @Autowired private DoctorsOfficeRepository doctorsOfficeRepository;
  @Autowired private AppointmentService appointmentService;

  @GetMapping("/create")
  public String getCreateAppointmentView(Model model) {
    model.addAttribute("doctors", doctorRepository.findAll());
    model.addAttribute("doctorOffices", doctorsOfficeRepository.findAll());

    model.addAttribute("appointment", new Appointment());

    return "createAppointment";
  }

  @PostMapping
  public String createAppointment(@ModelAttribute Appointment appointment) {
    appointmentService.createAppointment(appointment);
    return "createAppointment";
  }
}
