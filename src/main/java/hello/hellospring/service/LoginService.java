package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Boolean match(Member member){
        if(memberRepository.findByName(member.getName()) == null){
            return false;
        }
        else{
            if (memberRepository.findByPassword(member.getPassword()) == null){
                return false;
            }
            else{
                return true;
            }
        }
    }
}
