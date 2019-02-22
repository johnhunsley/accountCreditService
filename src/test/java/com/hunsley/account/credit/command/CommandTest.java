package com.hunsley.account.credit.command;

import com.hunsley.account.model.CurrentAccount;
import com.hunsley.account.model.LimitedAccount;
import com.hunsley.account.model.SavingsAccount;
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
    public void testCurrentAccountCreditCommand_AccountTypeFailure() {
        CurrentAccountCreditCommand command = new CurrentAccountCreditCommand(new LimitedAccount());

        try {
            command.creditAccount(100d);
            fail();
        } catch (CreditAccountCommandException e) {

        }
    }

    @Test
    public void testSavingsAccountCreditCommand() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setMaxDeposit(200d);
        SavingsAccountCreditCommand command = new SavingsAccountCreditCommand(savingsAccount);

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
    public void testSavingsAccountCreditCommand_MaxDepositFailure() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setMaxDeposit(100d);
        SavingsAccountCreditCommand command = new SavingsAccountCreditCommand(savingsAccount);

        try {
            assertEquals(99d, (double) command.creditAccount(99d));
            assertEquals(199d, (double) command.creditAccount(100d));

            try {
                command.creditAccount(200d);
                fail();
            } catch (CreditAccountCommandException e) {

            }

        } catch (CreditAccountCommandException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testSavingsAccountCreditCommand_AccountTypeFailure() {
        SavingsAccountCreditCommand command = new SavingsAccountCreditCommand(new LimitedAccount());

        try {
            command.creditAccount(100d);
            fail();
        } catch (CreditAccountCommandException e) {

        }
    }

    @Test
    public void testLimitedAccountCreditCommand() {
        LimitedAccount limitedAccount = new LimitedAccount();
        limitedAccount.setAccountLimit(300d);
        LimitedAccountCreditCommand command = new LimitedAccountCreditCommand(limitedAccount);

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
    public void testLimitedAccountCreditCommand_LimitFailure() {
        LimitedAccount limitedAccount = new LimitedAccount();
        limitedAccount.setAccountLimit(300d);
        LimitedAccountCreditCommand command = new LimitedAccountCreditCommand(limitedAccount);

        try {
            assertEquals(100d, (double) command.creditAccount(100d));
            assertEquals(200d, (double) command.creditAccount(100d));
            assertEquals(300d, (double) command.creditAccount(100d));

            try {
                command.creditAccount(1d);
                fail();
            } catch (CreditAccountCommandException e) {

            }

        } catch (CreditAccountCommandException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testLimitedAccountCreditCommand_AccountTypeFailure() {
        LimitedAccountCreditCommand command = new LimitedAccountCreditCommand(new SavingsAccount());

        try {
            command.creditAccount(100d);
            fail();
        } catch (CreditAccountCommandException e) {

        }
    }
}
