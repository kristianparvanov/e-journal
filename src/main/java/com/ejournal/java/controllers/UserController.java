package com.ejournal.java.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ejournal.java.dtos.auhtentication.UserLogin;

public class UserController {

  @PostMapping(value = "/login")
  public ResponseEntity login(@RequestBody UserLogin user) {
    return ResponseEntity.ok(null);
  }
}
