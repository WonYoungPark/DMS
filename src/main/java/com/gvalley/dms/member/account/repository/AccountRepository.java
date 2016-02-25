package com.gvalley.dms.member.account.repository;

import com.gvalley.dms.member.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-06
 * @since 0.1
 */

// #원리
// 1. 특정 인터페이스 타입에 따라 클래스를 찾는다.
// 2. 인터페이스 구현체의 객체를 만들어준다.
// 3. 생성된 객체를 빈으로 등록해준다.
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
