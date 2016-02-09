package com.gvalley.dms.develop.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-04
 * @since 0.1
 */
@Controller
public class SampleController {

    @RequestMapping("/sample.do")
    public String getPagePath(Model model) {
        model.addAttribute("name", "박원영");
        return "dms/base/sample/sample";
    }
}
