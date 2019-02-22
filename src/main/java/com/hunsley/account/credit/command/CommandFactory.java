package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;

/**
 * <p>
 *     A factory for producing typed instances of {@link CreditAccountCommand} for a given {@link Account} sub type
 * </p>
 * @author johnhunsley
 */
public interface CommandFactory {

    CreditAccountCommand getCommand(Account account);
}
