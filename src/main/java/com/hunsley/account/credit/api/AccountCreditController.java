package com.hunsley.account.credit.api;

import com.hunsley.account.credit.service.AccountCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountCreditController {

    @Autowired
    private AccountCreditService accountCreditService;


}
