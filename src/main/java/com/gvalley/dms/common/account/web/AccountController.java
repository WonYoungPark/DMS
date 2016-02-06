package com.gvalley.dms.common.account.web;

import com.gvalley.dms.common.account.domain.Account;
import com.gvalley.dms.common.account.repository.AccountDto;
import com.gvalley.dms.common.account.repository.AccountRepository;
import com.gvalley.dms.common.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Account newAccount = service.createAccount(create);

        return new ResponseEntity(newAccount, HttpStatus.CREATED);
    }

}
