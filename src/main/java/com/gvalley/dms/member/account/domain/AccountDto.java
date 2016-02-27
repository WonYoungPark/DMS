package com.gvalley.dms.member.account.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

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
        private String username;

        @NotBlank
        @Size(min = 5, max = 20)
        private String password;
    }

    @Data
    public static class Response {
        private Long id;
        private String username;
        private Date rgstDt;
        private Date updtDt;
    }

    @Data
    public static class Update {
        private String password;
        private Date rgstDt;
        private Long rgstId;
        private Date updtDt;
        private Long updtId;
    }
}
