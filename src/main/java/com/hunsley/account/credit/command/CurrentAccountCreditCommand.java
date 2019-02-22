package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;
import com.hunsley.account.model.CurrentAccount;

public class CurrentAccountCreditCommand extends CreditAccountCommand {

    CurrentAccountCreditCommand(Account account) {
        super(account);
    }

    @Override
    public Double creditAccount(Double credit) throws CreditAccountCommandException {
        if(!(account instanceof CurrentAccount))
            throw new CreditAccountCommandException(account.getClass().getName()+" is not an instance of "+CurrentAccount.class.getName());

        return super.setAccountValue(credit);
    }
}
