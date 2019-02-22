package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;
import com.hunsley.account.model.SavingsAccount;

public class SavingsAccountCreditCommand extends CreditAccountCommand {

    SavingsAccountCreditCommand(Account account) {
        super(account);
    }

    @Override
    public Double creditAccount(final Double credit) throws CreditAccountCommandException {
        if(!(account instanceof SavingsAccount))
            throw new CreditAccountCommandException(account.getClass().getName()+" is not an instance of "+ SavingsAccount.class.getName());

        SavingsAccount savingsAccount = (SavingsAccount) account;

        if(credit > savingsAccount.getMaxDeposit())
            throw new CreditAccountCommandException(
                    "Credit value " + credit +" is greater than SavingsAccount max deposit value "+savingsAccount.getMaxDeposit());

        return super.setAccountValue(credit);

    }
}
