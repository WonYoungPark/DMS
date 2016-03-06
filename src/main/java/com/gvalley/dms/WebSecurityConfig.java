package com.gvalley.dms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsService userDetailsService;

    // 설명 : userDetailsService와 passwordEncoder를 AuthenticationManagerBuilder에 세팅해 준다.(사용자의 username과 password가 맞는지 확인한다.)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

    }

    // 설명 : 특정 요청에 대해서 시큐리티 설정을 무시하도록 하는 정체에 관한 설정을 함.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/resources/**", "/webjars/**, /h2console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // csrf는 기본으로 켜져있음. GET 이외의 요청이 들어오면 spring security가 csrf토큰값을 검증한다.

        http.httpBasic(); // 인증방식

        // 인가 관련 설정
        http
                .authorizeRequests()
//                    .antMatchers(HttpMethod.GET, "/account/**").hasRole("USER") // USER를 가지고 있는 사람에게만 허용함.
//                    .antMatchers(HttpMethod.PUT, "/account/**").hasRole("USER") // USER를 가지고 있는 사람에게만 허용함.
//                    .antMatchers(HttpMethod.DELETE, "/account/**").hasRole("USER") // USER를 가지고 있는 사람에게만 허용함.
//                    .anyRequest().permitAll(); // 나머지는 허용
                    .antMatchers("gse/com/system/login").anonymous()
                    .anyRequest().authenticated()
        ;

        // 로그인 관련 설정
        http
                .formLogin() // 인증 처리 경로
                    .loginPage("gse/com/system/login") // 로그인 페이지 경로
                    .loginProcessingUrl("gse/com/system/login-process.html") // 로그인 Form 표시 경로(HTML form tag의 action 값과 동일해야함.)
                    //.failureUrl("gse/com/system/login") // 인증 실패시 이동 경로
                    .defaultSuccessUrl("gse/com/system/index.html", true) // 인증 성공시 이동 경로
                    .usernameParameter("username").passwordParameter("password") // 사용자 이름과 암호 관련 파라미터 이름 설정
                .and()
                .rememberMe()
                    .tokenValiditySeconds(2419200) // 4주 ( 기본값 2주 )
                    .key("SpringSecured") // 개인키
        ;

        // 로그아웃 관련 설정
//        http
//                .logout()
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout**")) // 로그아웃 처리 경로
//                    .logoutSuccessUrl("/gse/com/system/login?error") // 로그아웃 성공시 이동 경로
//        ;

    }
    // ROLE Hieracry


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/","/js/**", "/css/**", "/fonts/**", "/user/signup", "/api/**", "/com/develop/*", "/h2console/**", "/sample1", "/index", "/**").permitAll() /*로그인 없이 접속 할 수 있는 위치*/
//                .anyRequest().authenticated();
//        http
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//
//        // H2 Database 콘솔 출력을 위한 옵션 세팅
//        // H2 데이터베이스는 하나의 프레임안에서 동작하므로 다음의 시큐리티 설정을 추가해줘야한다.
//        // 주의 : 개발단계에서만 사용!! ( H2데이터베이스 콘솔 외부로 노출되는 위험현상 발생 )
//        http.csrf().disable(); // CSRF 보호설정 비활성
//        http.headers().frameOptions().disable(); // 스프링 시큘티의 X-Frame-Option 비활성
//    }
}
