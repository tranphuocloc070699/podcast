package com.podcast.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.podcast.server.config.MicroConfig;
import com.podcast.server.model.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping("api/v1/video")
public class VideoController {
  
  @Autowired
  MicroConfig microConfig;
  
  @GetMapping("/")
  public String home(){
    System.out.println("Hello");
    return "Hello";
  }
  
  @GetMapping("/properties")
  public String getPropertyDetails() throws JsonProcessingException {
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    Properties properties = new Properties(microConfig.getMsg(), microConfig.getBuildVersion(),
            microConfig.getMailDetails(), microConfig.getActiveBranches());
    return ow.writeValueAsString(properties);
  }

}
