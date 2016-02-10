package com.gvalley.dms.member.account.domain;

public class AccountNotFoundException extends RuntimeException {

    String userId;

    public AccountNotFoundException(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
