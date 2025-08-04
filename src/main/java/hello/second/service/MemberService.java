package hello.second.service;

import hello.second.domain.Member;
import hello.second.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //final을 쓰면 memberRepository가 자동으로 생성되는 명령어
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
    public Long join(Member member) {
        
        //같은 이름이 있는 중복회원 검증
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByUserid(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMemberList() {
        return memberRepository.findAll();
    }

    //회원 한 명 조회
    public Optional<Member> findOneMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //회원 삭제
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}