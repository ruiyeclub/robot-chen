package cn.ruiyeclub.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ray。
 * @date 2020/8/27
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/","index","index.html"})
    public String toIndex(){
        return "index";
    }

}
