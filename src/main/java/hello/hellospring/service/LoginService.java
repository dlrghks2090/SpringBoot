package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Boolean match(Member member){
        Optional<Member> tmpMember = memberRepository.findByName(member.getName());
        if(tmpMember == null){
            System.out.println("1");
            System.out.println(memberRepository.findByName(member.getName()));
            return false;
        }
        else{
            if (tmpMember.get().getPassword().equals(member.getPassword())){
                System.out.println("2");
                System.out.println(memberRepository.findByName(member.getName()));
                return true;
            }
            else{
                System.out.println("3");
                System.out.println(memberRepository.findByName(member.getName()));
                return false;
            }
        }
    }
}
