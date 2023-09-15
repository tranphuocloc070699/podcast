package com.podcast.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Account {
  
 
  private int customerId;


  private long accountNumber;

  private String accountType;

  private String branchAddress;

  private LocalDate createDt;
  
}
