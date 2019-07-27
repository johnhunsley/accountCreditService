package com.hunsley.account.credit.service;

import com.hunsley.account.credit.command.CommandFactory;
import com.hunsley.account.credit.command.CreditAccountCommand;
import com.hunsley.account.credit.command.CreditAccountCommandException;
import com.hunsley.account.model.Account;
import com.hunsley.account.model.AccountsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

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
    public void creditCustomerAccounts(final Integer uid, final Double credit) throws AccountCreditException {
        //get accounts from remote service
        Map<String, String> params = new HashMap<>();
        params.put("uid", uid.toString());
        AccountsResponse<Account> response =
                restTemplate.exchange(
                        accountsUrl, HttpMethod.GET, null, AccountsResponse.class, params).getBody();

        //iterate and create and apply command for each
        for(Account account : response.getEmbeddedCurrentAccounts()) {
            CreditAccountCommand command = commandFactory.getCommand(account);

            try {
                command.creditAccount(credit);

            } catch (CreditAccountCommandException e) {
                throw new AccountCreditException(e);
            }
        }
    }

//    /**
//     *
//     * @param uid
//     * @return
//     */
//    private List<Account> loadAccounts(Integer uid) {
//        RestTemplate
//    }
}
