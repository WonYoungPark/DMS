package com.gvalley.dms.common.account.service;

import com.gvalley.dms.common.account.domain.Account;
import com.gvalley.dms.common.account.repository.AccountDto;
import com.gvalley.dms.common.account.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-06
 * @since 0.1
 */
// @Service 어노테이션을 입력하여 ComponentScan에 의해 빈으로 등록되도록 한다.
@Service
@Transactional
public class AccountService {

    // @Autowired 어노테이션을 통해 AccountRepository를 가지고 있게끔 한다.
    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Account createAccount(AccountDto.Create dto) {

        //dto 객체 안에 들어있는 내용을 Account 클래스타입의 인스턴스로 옮긴다.
        Account account = modelMapper.map(dto, Account.class);
        // 동일코드 modelMapper 를 통해 한줄로 요약가능
//        Account account = new Account();
//        account.setUserId(dto.getUserId());
//        account.setUserName(dto.getUserName());
//        account.setPassword(dto.getPassword());
//        account.setRgstUserId(dto.getUserId());
//        account.setUpdtUserId(dto.getUserId());

        Date date = new Date();
        account.setRgstDtm(date);
        account.setUpdtDtm(date);

        return repository.save(account);
    }
}


