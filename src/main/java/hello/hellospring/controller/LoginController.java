package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){

        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String createlogin(){
        return "login/loginForm";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setPassword(form.getPassword());

        System.out.println("testcode 입니당");
        System.out.println(member.getName());
        System.out.println(member.getPassword());

        if(loginService.match(member) == true){
            return "redirect:/";
        }
        else {
            return "login/loginForm";
        }
    }


}


