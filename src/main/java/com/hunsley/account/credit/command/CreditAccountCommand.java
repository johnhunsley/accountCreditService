package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;

public abstract class CreditAccountCommand {

    protected final Account account;

    /**
     *
     * @param account
     */
    CreditAccountCommand(final Account account) {
        this.account = account;
    }

    protected final Double setAccountValue(Double credit) {
        final Double value =  account.getValue() + credit;
        account.setValue(value);
        return value;
    }

    /**
     * <p>
     *
     * </p>
     * @return
     */
    public abstract Double creditAccount(Double credit) throws CreditAccountCommandException;
}
