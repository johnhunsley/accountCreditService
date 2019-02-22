package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;

/**
 * <p>
 *     A command pattern implementation of the business logic for crediting an {@link Account}. Subtypes of this Command
 *     type must implement the logic for crediting a specific {@link Account} type.
 * </p>
 * @author johnhunsley
 */
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
     *  Credit the {@link Account} according to the logic implemented for the pre defined type
     * </p>
     * @return the Double value of the account once successfully credited
     * @throws {@link CreditAccountCommandException} should the {@link Account} not be able to be successfully credited
     */
    public abstract Double creditAccount(Double credit) throws CreditAccountCommandException;
}
