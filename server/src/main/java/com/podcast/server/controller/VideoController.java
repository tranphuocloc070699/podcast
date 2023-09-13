package com.podcast.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/video")
public class VideoController {
  
  @GetMapping("/")
  public String home(){
    System.out.println("Hello");
    return "Hello";
  }

}
