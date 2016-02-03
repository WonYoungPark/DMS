package com.gvalley.dms;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-04
 * @since 0.1
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/js/**", "/css/**", "/fonts/**", "/user/signup", "/api/**", "/com/develop/*", "/h2console/**", "/sample").permitAll() /*로그인 없이 접속 할 수 있는 위치*/
                .anyRequest().authenticated();
        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        // H2 Database 콘솔 출력을 위한 옵션 세팅
        // H2 데이터베이스는 하나의 프레임안에서 동작하므로 다음의 시큐리티 설정을 추가해줘야한다.
        // 주의 : 개발단계에서만 사용!! ( H2데이터베이스 콘솔 외부로 노출되는 위험현상 발생 )
        http.csrf().disable(); // CSRF 보호설정 비활성
        http.headers().frameOptions().disable(); // 스프링 시큘티의 X-Frame-Option 비활성
    }
}
