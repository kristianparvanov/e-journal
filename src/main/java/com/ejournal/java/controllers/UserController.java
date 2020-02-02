package com.ejournal.java.controllers;

import com.ejournal.java.entities.UserLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

  @PostMapping(value = "/login")
  public ResponseEntity login(@RequestBody UserLogin user) {
    return ResponseEntity.ok(null);
  }
}
