package com.hunsley.account.credit.command;

public class CreditAccountCommandException extends Exception {

    public CreditAccountCommandException() {
    }

    public CreditAccountCommandException(String message) {
        super(message);
    }

    public CreditAccountCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreditAccountCommandException(Throwable cause) {
        super(cause);
    }

    public CreditAccountCommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
