package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;
import com.hunsley.account.model.CurrentAccount;
import org.springframework.stereotype.Service;

@Service
public class CommandFactoryImpl implements CommandFactory {

    @Override
    public CreditAccountCommand getCommand(final Account account) {

        if(account instanceof CurrentAccount)
            return new CurrentAccountCreditCommand(account);


        throw new IllegalArgumentException(account.getClass().getName()+" is not a known type");
    }
}
