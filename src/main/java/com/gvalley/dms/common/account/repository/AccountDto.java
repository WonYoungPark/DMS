package com.gvalley.dms.common.account.repository;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-06
 * @since 0.1
 */
public class AccountDto {

    @Data
    public static class Create {

        @NotBlank
        @Size(min = 5, max = 20)
        private String userId;

        @NotBlank
        @Size(min = 5, max = 20)
        private String userName;

        @NotBlank
        @Size(min = 5, max = 20)
        private String password;
    }
}
