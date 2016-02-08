package com.gvalley.dms;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @since 0.1
 * @Date 2016-02-04
 */
// @EnableAutoConfiguration 은 Spring Boot가 클래스패스 세팅, 다른 Bean들, 다양한 설정들에 의해 Bean을 추가하도록 합니다.
// 일반적으로 기존의 Spring MVC 어플리케이션에서는 @EnableWebMvc 태그를 사용했지만 Spring Boot는 클래스패스에서 spring-webmvc를 발견할 경우 자동으로 추가합니다. 이러한 플래그는 DispatcherServlet을 세팅하는것과 같은 개발중인 어플리케이션을 웹어플리케이션으로 활성화 하는 핵심 키가 됩니다.
// @ComponentScan 은 Spring에게 hello 패키지 안에서 다른 컴포넌트, 설정, 서비스를 찾도록 합니다. 이 설정을 통해 HelloController를 찾는것이 가능해집니다.
@EnableWebMvc
@Configuration //태그는 현재의 클래스가 Spring의 설정파일임을 어플리케이션 컨텍스트에게 알려주는 역할을 합니다.
public class WebConfig extends WebMvcConfigurerAdapter {

    // H2 Database 콘솔 접근 URL 설정
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/h2console/*");
        return registration;
    }

    // <mvc:default-servlet-handler>와 동일한 기능
    // WebMvcConfigurerAdapter class 를 오버라이딩해서 정적자원처리가 디폴트 서블릿으로 위임되게 한다.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // ViewResolver 설정
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    // UTF-8 Filter 설정
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
//        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/").setCachePeriod(31556926);
//        registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/").setCachePeriod(31556926);
//        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/").setCachePeriod(31556926);
//    }
}
