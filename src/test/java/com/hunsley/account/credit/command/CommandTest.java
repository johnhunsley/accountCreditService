package com.hunsley.account.credit.command;

import com.hunsley.account.model.CurrentAccount;
import com.hunsley.account.model.LimitedAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommandTest {

    @Test
    public void testCurrentAccountCreditCommand() {
        CurrentAccountCreditCommand command = new CurrentAccountCreditCommand(new CurrentAccount());

        try {
            assertEquals(100d, (double) command.creditAccount(100d));
            assertEquals(200d, (double) command.creditAccount(100d));
            assertEquals(300d, (double) command.creditAccount(100d));

        } catch (CreditAccountCommandException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testCurrentAccountCreditCommand_Failure() {
        CurrentAccountCreditCommand command = new CurrentAccountCreditCommand(new LimitedAccount());

        try {
            command.creditAccount(100d);
            fail();
        } catch (CreditAccountCommandException e) {

        }
    }
}
