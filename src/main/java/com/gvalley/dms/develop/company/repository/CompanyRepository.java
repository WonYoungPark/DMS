package com.gvalley.dms.develop.company.repository;

import com.gvalley.dms.develop.company.domain.Company;
import com.gvalley.dms.member.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by wyPark on 2016. 2. 27..
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
