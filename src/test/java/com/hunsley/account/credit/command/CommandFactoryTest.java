package com.hunsley.account.credit.command;

import com.hunsley.account.model.Account;
import com.hunsley.account.model.CurrentAccount;
import com.hunsley.account.model.LimitedAccount;
import com.hunsley.account.model.SavingsAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommandFactoryTest {

    @Autowired
    private CommandFactory commandFactory;

    @Test
    public void testGetCommand() {
        CreditAccountCommand command1 = commandFactory.getCommand(new CurrentAccount());
        assertTrue(command1 instanceof CurrentAccountCreditCommand);

        CreditAccountCommand command2 = commandFactory.getCommand(new SavingsAccount());
        assertTrue(command2 instanceof SavingsAccountCreditCommand);

        CreditAccountCommand command3 = commandFactory.getCommand(new LimitedAccount());
        assertTrue(command3 instanceof LimitedAccountCreditCommand);
    }

    @Test
    public void testGetCommand_Failure() {

        try {
            CreditAccountCommand command1 = commandFactory.getCommand(new Account() {});
            fail();
        } catch (IllegalArgumentException ex) {

        }
    }
}
