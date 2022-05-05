package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String createlogin(){
        return "login/login";
    }
    @PostMapping("/login")
    public String login(LoginForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setPassword(form.getPassword());

        if(loginService.match(member) == true){
            return "redirect:/";
        }
        else {
            return "login/login";
        }
    }


}


