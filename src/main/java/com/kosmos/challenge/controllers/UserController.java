package com.kosmos.challenge.controllers;

import com.kosmos.challenge.entities.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
  @GetMapping("/me")
  public String me(Model model, @AuthenticationPrincipal User user) {
    model.addAttribute(user);
    return "me";
  }
}
