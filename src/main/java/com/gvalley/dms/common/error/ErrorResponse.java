package com.gvalley.dms.common.error;

import java.util.List;

import lombok.Data;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-14
 * @since 0.1
 */
@Data
public class ErrorResponse {

    private String message;

    private String code;

    private List<FieldError> errors;

    public static class FieldError {
        private String field;
        private String value;
        private String reason;
    }
}
