package com.hunsley.account.credit.service;

public class AccountCreditException extends Exception {

    public AccountCreditException() {
    }

    public AccountCreditException(String message) {
        super(message);
    }

    public AccountCreditException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountCreditException(Throwable cause) {
        super(cause);
    }

    public AccountCreditException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
