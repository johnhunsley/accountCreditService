package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;
import com.hunsley.account.model.LimitedAccount;

public class LimitedAccountCreditCommand extends CreditAccountCommand {

    LimitedAccountCreditCommand(Account account) {
        super(account);
    }

    @Override
    public Double creditAccount(final Double credit) throws CreditAccountCommandException {
        if(!(account instanceof LimitedAccount))
            throw new CreditAccountCommandException(account.getClass().getName()+" is not an instance of "+ LimitedAccount.class.getName());

        LimitedAccount limitedAccount = (LimitedAccount)account;

        if((limitedAccount.getValue() + credit) > limitedAccount.getAccountLimit())
            throw new CreditAccountCommandException(
                    "Credit value "+credit+" will exceed limited account value "+limitedAccount.getAccountLimit());

        return super.setAccountValue(credit);
    }
}
