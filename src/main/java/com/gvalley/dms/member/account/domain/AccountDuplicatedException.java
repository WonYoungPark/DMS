package com.gvalley.dms.member.account.domain;

public class AccountDuplicatedException extends RuntimeException {

    String userId;

    public AccountDuplicatedException(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
