package com.ejournal.java.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


public class UploadController {

  @PostMapping(value = "/upload")
  public ResponseEntity upload(@RequestPart("file") MultipartFile file) {
    return ResponseEntity.ok(null);
  }
}
