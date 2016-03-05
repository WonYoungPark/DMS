package com.gvalley.dms.member.account.service;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gvalley.dms.member.account.domain.Account;
import com.gvalley.dms.member.account.domain.AccountDto;
import com.gvalley.dms.member.account.domain.AccountDuplicatedException;
import com.gvalley.dms.member.account.domain.AccountNotFoundException;
import com.gvalley.dms.member.account.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class AccountService {

    // Lombok에서 Slf4j 어노테이션을 사용하면 아래 코드가 자동생성된다.
    //private Logger log = LoggerFactory.getLogger(this.getClass());

    // @Autowired 어노테이션을 통해 AccountRepository를 가지고 있게끔 한다.
    @Autowired
    private AccountRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

        String username = dto.getUsername();
        if (repository.findByUsername(username) != null) {
            log.error("user duplicated excpetion. {}", username);
            throw new AccountDuplicatedException(username);
        }

        account.setPassword(passwordEncoder.encode(account.getPassword()));

        Date now = new Date();
        account.setRgstDt(now);
        account.setUpdtDt(now);

        return repository.save(account);
    }

    public Account getAccount(Long id) {
        Account account = repository.findOne(id);

        if (account == null) {
            throw new AccountNotFoundException(id);
        }

        return account;
    }

    public Account updateAccount(Long id, AccountDto.Update updateDto) {
        Account account = getAccount(id);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return repository.save(account);
    }

    public void deleteAccount(Long id) {
        repository.delete(getAccount(id));
    }
}


