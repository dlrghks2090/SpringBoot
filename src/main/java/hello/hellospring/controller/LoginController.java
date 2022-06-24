package hello.hellospring.controller;

import groovy.util.logging.Slf4j;
import hello.hellospring.domain.Member;
import hello.hellospring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Slf4j
@Controller
public class LoginController {

    private static final String LOGIN_MEMBER = "LOGIN_MEMBER";

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
    public String login(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request, Model model){
        Member member = new Member();
        member.setName(form.getName());
        member.setPassword(form.getPassword());

        if(loginService.match(member) == true){

            // 로그인 성공 처리
            // 세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
            HttpSession session = request.getSession();

            // 세션에 로그인 회원 정보 보관
            session.setAttribute(LOGIN_MEMBER, member);

            model.addAttribute("member", member);

            return "login/loginedHome";
        }
        else {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");

            return "login/loginForm";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if(session != null){
            session.invalidate(); // 세션 날림
        }
        return "home";
    }


}


