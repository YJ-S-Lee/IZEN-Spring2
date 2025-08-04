package hello.second.domain;

import hello.second.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void 맴버저장() {
        Member member1 = new Member();
        member1.setUserid("test");
        member1.setName("사용자1");
        memberRepository.save(member1);
    }

    @Test
    void 아이디로찾기() {
        Optional<Member> findMember1 = memberRepository.findByUserid("test");
        if(findMember1.isPresent()) {
            Member member = findMember1.get();
            Assertions.assertEquals("test", member.getUserid());
        }
    }

}