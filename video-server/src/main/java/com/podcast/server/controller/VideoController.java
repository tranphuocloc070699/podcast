package com.podcast.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.podcast.server.config.MicroConfig;
import com.podcast.server.model.Account;
import com.podcast.server.model.Properties;
import com.podcast.server.service.AccountFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("api/v1/video")
public class VideoController {
  
  @Autowired
  MicroConfig microConfig;
  
  @Autowired
  AccountFeignClient accountFeignClient;
  
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
  
  @GetMapping("/accounts")
  @CircuitBreaker(name = "detailsForCustomerSupportApp",fallbackMethod="myCustomerDetailsFallBack")
  public Iterable<Account> getAccounts(){
    return  accountFeignClient.getAccounts();
  }
  
  private Iterable<Account> myCustomerDetailsFallBack(Exception e){
    Account account = new Account();
    account.setAccountNumber(123456);
    account.setBranchAddress(e.getMessage());
    return List.of(account);
  }
  
  @GetMapping("/sayHello")
  @RateLimiter(name = "sayHello", fallbackMethod = "sayHelloFallback")
  public String sayHello() {
    return "Hello, Welcome to EazyBank";
  }
  
  private String sayHelloFallback(Exception e) {
    return e.getMessage();
  }

}
