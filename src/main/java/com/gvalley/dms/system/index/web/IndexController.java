package com.gvalley.dms.system.index.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-08
 * @since 0.1
 */
@Controller
public class IndexController {
    // SITE http://lahuman.jabsiri.co.kr/85

    @RequestMapping(method = RequestMethod.GET, value = "/index.do")
    public String getPagePath() {
        Date date = new Date();
        System.out.println("IndexController 실행 - /index : " + date.toString());
        return "gse/com/system/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/main.do")
    public String getPagePath1(Model model) {
        Date date = new Date();
        System.out.println("IndexController 실행 - /main : " + date.toString());
        return "main";
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}

