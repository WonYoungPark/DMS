package com.gvalley.dms.member.account.web;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gvalley.dms.member.account.domain.Account;
import com.gvalley.dms.member.account.domain.AccountDto;
import com.gvalley.dms.member.account.domain.AccountDuplicatedException;
import com.gvalley.dms.member.account.domain.AccountNotFoundException;
import com.gvalley.dms.member.account.repository.AccountRepository;
import com.gvalley.dms.member.account.service.AccountService;
import com.gvalley.dms.common.error.domain.ErrorResponse;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-06
 * @since 0.1
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/account")
    public String getPagePath(Model model) {
        model.addAttribute("name", "박원영");
        return "/com/gvalley.dms.develop/account";
    }

    // @RequestBody 사용 이유
    // 최근 ServerSide 개발시 Rest API 개발로 인하 ㄴRequest 본문으로 들어오는걸 파싱하는방법을 사용
    // RequestBody를 사용할시 MessageConverter(jSon2 Converter)가 동작함.
    // Request 본문에 들어있는 jSon 데이터를 객체로 바인딩 해준다.
    @RequestMapping(method = RequestMethod.POST, value = "/account/create")
    public ResponseEntity createAccount(@RequestBody @Valid AccountDto.Create create,
                                       BindingResult result // Validation 이전에 바인딩 결과를 확인할수 있다.
    ) {
        if ( result.hasErrors()) {
            // TODO 에러 응답 본문 추가하기
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("잘못된 요청입니다.");
            errorResponse.setCode("bad.request");
            // BindingResult 안에 들어있는 에러정보 사용하기.
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        Account newAccount = service.createAccount(create);

        return new ResponseEntity<>(modelMapper.map(newAccount, AccountDto.Response.class),
                                    HttpStatus.CREATED);
    }

    // 에러처리
    @ExceptionHandler(AccountDuplicatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAccountDuplicatedException(AccountDuplicatedException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("[" + e.getUserId() + "] 중복된 userId 입니다.");
        errorResponse.setCode("duplicated.userId.exception");
        return errorResponse;
    }

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAccountNotFoundException(AccountNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("[" + e.getUserId() + "]에 해당하는 계정이 없습니다.");
        errorResponse.setCode("account.not.found.exception");
        return errorResponse;
    }
}
