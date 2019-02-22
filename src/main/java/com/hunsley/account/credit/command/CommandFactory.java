package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;
import org.springframework.stereotype.Service;


public interface CommandFactory {

    CreditAccountCommand getCommand(Account account);
}
