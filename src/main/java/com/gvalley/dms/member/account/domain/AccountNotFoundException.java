package com.gvalley.dms.member.account.domain;
/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-14
 * @since 0.1
 */
public class AccountNotFoundException extends RuntimeException {

    Long id;

    public AccountNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
