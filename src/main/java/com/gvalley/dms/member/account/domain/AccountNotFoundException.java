package com.gvalley.dms.member.account.domain;
/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-14
 * @since 0.1
 */
public class AccountNotFoundException extends RuntimeException {

    Long userId;

    public AccountNotFoundException(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
