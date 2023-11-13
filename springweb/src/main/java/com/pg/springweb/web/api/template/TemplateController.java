package com.pg.springweb.web.api.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemplateController {

    @GetMapping("index")
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){

        model.addAttribute("name",name);
        return "index";
    }


    @GetMapping("subpage/sub1")
    public String sub1(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){

        model.addAttribute("name",name);
        return "subpage/sub1";
    }
}
