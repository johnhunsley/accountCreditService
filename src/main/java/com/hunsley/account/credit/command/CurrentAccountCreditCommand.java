package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;
import com.hunsley.account.model.CurrentAccount;

public class CurrentAccountCreditCommand extends CreditAccountCommand {

    public CurrentAccountCreditCommand(Account account) {
        super(account);
    }

    @Override
    public Double creditAccount(Double credit) {
        CurrentAccount currentAccount = (CurrentAccount)account;
        return super.setAccountValue(credit);
    }
}
