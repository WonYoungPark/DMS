package com.gvalley.dms.common.security;

import com.gvalley.dms.member.account.domain.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-17
 * @since 0.1
 */
public class UserDetailsImpl extends User {

    public UserDetailsImpl(Account account) {
        super(account.getUsername(), account.getPassword(), authorities(account));
    }

    private static Collection<? extends GrantedAuthority> authorities(Account account) {
        List<GrantedAuthority> authorities = new ArrayList<>();

//        if(account.isAdminYn()) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else {
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (account.isAdminYn()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return authorities;
    }
}
