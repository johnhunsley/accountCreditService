package com.hunsley.account.credit.service;

/**
 * <p>
 *
 * </p>
 * @author johnhunsley
 */
public interface AccountCreditService {


    /**
     * <p>
     *
     * </p>
     * @param uid
     * @throws AccountCreditException
     */
    void creditCustomerAccounts(Integer uid) throws AccountCreditException;
}
