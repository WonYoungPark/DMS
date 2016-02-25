package com.gvalley.dms.member.account.domain;
/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-14
 * @since 0.1
 */
public class AccountDuplicatedException extends RuntimeException {

    String username;

    public AccountDuplicatedException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
