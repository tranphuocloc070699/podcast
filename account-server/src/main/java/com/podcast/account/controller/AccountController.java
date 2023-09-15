package com.podcast.account.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.podcast.account.config.MicroConfig;
import com.podcast.account.model.Account;
import com.podcast.account.model.Customer;
import com.podcast.account.model.Properties;
import com.podcast.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/**
 * @author Eazy Bytes
 *
 */

@RestController
public class AccountController {
  
  @Autowired
  private AccountRepository accountsRepository;
  
  @Autowired
  private MicroConfig microConfig;
  
  
  

  
  @PostMapping("/accounts")
  public Iterable<Account> getAccounts() {
    
    Iterable<Account> accounts = accountsRepository.findAll();
    System.out.println(accounts.toString());
    if (accounts != null) {
      return accounts;
    } else {
      return null;
    }
  }
  
  @GetMapping("/account/properties")
  public String getPropertyDetails() throws JsonProcessingException {
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    Properties properties = new Properties(microConfig.getMsg(), microConfig.getBuildVersion(),
            microConfig.getMailDetails(), microConfig.getActiveBranches());
    String jsonStr = ow.writeValueAsString(properties);
    return jsonStr;
  }
  
}
