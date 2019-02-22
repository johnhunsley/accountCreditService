package com.hunsley.account.credit.service;

import com.hunsley.account.credit.command.CommandFactory;
import com.hunsley.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Service("accountCreditService")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountCreditServiceImpl implements AccountCreditService {

    @Autowired
    private CommandFactory commandFactory;

    private RestTemplate restTemplate;

    @Value("${com.hunsley.accounts.service.url}")
    private String accountsUrl;

    public AccountCreditServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @Override
    public void creditCustomerAccounts(Integer uid) throws AccountCreditException {
        //get accounts from remote service
        restTemplate.get

        //iterate and create and apply command for each

        //collate results - value and account ids

    }

    /**
     *
     * @param uid
     * @return
     */
    private List<Account> loadAccounts(Integer uid) {
        RestTemplate
    }
}
