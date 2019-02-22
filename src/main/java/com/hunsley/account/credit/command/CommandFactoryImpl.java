package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;
import com.hunsley.account.model.CurrentAccount;
import com.hunsley.account.model.LimitedAccount;
import com.hunsley.account.model.SavingsAccount;
import org.springframework.stereotype.Service;

/**
 * @author johnhunsley
 */
@Service("commandFactory")
public class CommandFactoryImpl implements CommandFactory {

    /**
     * <p>
     *     return a new concrete instance of the {@link CreditAccountCommand} for the given {@link Account} type
     *     and links the given account instance to the returned command instance.
     * </p>
     * @param account
     * @return a concrete {@link CreditAccountCommand} type
     * @throws {@link IllegalArgumentException} if the given {@link Account} has no known associated command
     */
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
