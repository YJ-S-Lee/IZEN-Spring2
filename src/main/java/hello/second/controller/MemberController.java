package hello.second.controller;

import hello.second.domain.Member;
import hello.second.dto.MemberForm;
import hello.second.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm() {
        return "/members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createFormPost(MemberForm memberForm) {
        Member member = new Member();
        member.setUserid(memberForm.getUserid());
        member.setName(memberForm.getName());
        memberService.join(member);
        return "redirect:/members/List";
    }

    @GetMapping("/members/List")
    public String Listmember(Model model) {
        List<Member> memberList = memberService.findMemberList();
        model.addAttribute("memberList", memberList);
        return "/members/memberList";
    }

    //삭제하기
    @GetMapping("/members/delete/{memberid}")
    public String delete(@PathVariable("memberid") Long memberid) {
        Optional<Member> oneMember = memberService.findOneMember(memberid);
        if(oneMember.isPresent()) {
            Member member = oneMember.get();
            memberService.deleteMember(member.getId());
        }
        return "redirect:/members/list";
    }

}