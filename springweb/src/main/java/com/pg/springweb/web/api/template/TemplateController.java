package com.pg.springweb.web.api.template;

import com.pg.springweb.entity.Message;
import com.pg.springweb.entity.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("subpage/form")
    public String form(Model model){

        model.addAttribute("user",new User("xiaoli",18, User.Sex.MAN));
        return "subpage/form";
    }

    @PostMapping("user")
    public String saveUser(@Valid User user, Errors errors, Model model){

        if(errors.hasErrors()){
            return "subpage/form";
        }
        return "redirect:/subpage/sub1";
    }



    @ModelAttribute("message")
    public Message setMessage(){
        return new Message("helloworld","msg001");
    }

    @ModelAttribute
    public void addUser(Model model){
        List<User> users = new ArrayList<>();
        users.add(new User("man001",10, User.Sex.MAN));

        users.add(new User("woman001",10, User.Sex.WOMEN));
        users.add(new User("woman002",10, User.Sex.WOMEN));
        users.add(new User("man002",10, User.Sex.MAN));
        model.addAttribute("men",users.stream().filter(user -> User.Sex.MAN.equals(user.getSex())).collect(Collectors.toList()));
        model.addAttribute("women",users.stream().filter(user -> User.Sex.MAN.equals(user.getSex())).collect(Collectors.toList()));
    }
}
