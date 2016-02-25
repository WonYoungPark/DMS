package com.gvalley.dms.common.error;

import com.gvalley.dms.member.account.domain.AccountDuplicatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-14
 * @since 0.1
 */
@ControllerAdvice
public class ExceptionHandlers {
//    @ExceptionHandler(AccountDuplicatedException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse handleAccountDuplicatedException(AccountDuplicatedException e) {
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setMessage("[" + e.getUserId() + "] 중복된 userId 입니다.");
//        errorResponse.setCode("duplicated.userId.exception");
//
//        return errorResponse;
//    }
}
