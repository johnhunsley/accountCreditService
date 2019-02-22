package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;
import com.hunsley.account.model.CurrentAccount;
import com.hunsley.account.model.LimitedAccount;
import com.hunsley.account.model.SavingsAccount;
import org.springframework.stereotype.Service;

@Service("commandFactory")
public class CommandFactoryImpl implements CommandFactory {

    @Override
    public CreditAccountCommand getCommand(final Account account) {

        if(account instanceof CurrentAccount)
            return new CurrentAccountCreditCommand(account);

        if(account instanceof SavingsAccount)
            return new SavingsAccountCreditCommand(account);

        if(account instanceof LimitedAccount)
            return new LimitedAccountCreditCommand(account);

        throw new IllegalArgumentException(account.getClass().getName()+" is not a known type");
    }
}
