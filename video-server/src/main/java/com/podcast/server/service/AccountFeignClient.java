package com.podcast.server.service;

import com.podcast.server.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("account")
public interface AccountFeignClient {
  @RequestMapping(method = RequestMethod.POST, value = "accounts", consumes = "application/json")
  Iterable<Account> getAccounts();
}
