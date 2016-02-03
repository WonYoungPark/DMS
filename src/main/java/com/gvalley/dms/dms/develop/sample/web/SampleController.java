package com.gvalley.dms.dms.develop.sample.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-04
 * @since 0.1
 */
@RestController
public class SampleController {
    @RequestMapping("/sample")
    public String getPagePath(Model model) {
        model.addAttribute("name", "박원영");
        return "/com/develop/sample";
    }
}
