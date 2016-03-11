package com.gvalley.dms.member.login.web;

import com.gvalley.dms.member.account.repository.AccountRepository;
import com.gvalley.dms.member.account.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by wyPark on 2016. 2. 27..
 */
@Controller
public class LoginController {
    @Autowired
    private AccountService service;

    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/login")
    public ModelAndView getPagePath(ModelAndView modelAndView) {
        modelAndView.setViewName("gse/com/system/login");
        return modelAndView;
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "gse/com/system/test";
    }
}
