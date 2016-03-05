package com.gvalley.dms.member.login.web;

import com.gvalley.dms.member.account.repository.AccountRepository;
import com.gvalley.dms.member.account.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/login", method = POST)
    public String getPagePath() {
        //return "/login";
        return "/gse/com/system/login";
    }
}
