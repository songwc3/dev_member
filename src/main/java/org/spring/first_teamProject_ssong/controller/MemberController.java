package org.spring.first_teamProject_ssong.controller;

import lombok.RequiredArgsConstructor;
import org.spring.first_teamProject_ssong.config.MyUserDetails;
import org.spring.first_teamProject_ssong.dto.MemberDto;
import org.spring.first_teamProject_ssong.service.MemberService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // Create
    @GetMapping("/join")
    public String join(MemberDto memberDto){
        return "member/join";
    }

    @PostMapping("/join")
    public String joinPost(@Valid MemberDto memberDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "member/join";
        }

        memberService.insertMember(memberDto);
        return "redirect:/";
    }

    // Login
    @GetMapping("/login")
    public String login(){
        return "member/login";
    }

    // Read
    @GetMapping("/memberList")
    public String memberList(@AuthenticationPrincipal MyUserDetails myUserDetails, Model model){
        List<MemberDto> memberDtoList=memberService.ListMember();

        model.addAttribute("memberDtoList", memberDtoList);
        model.addAttribute("myUserDetails", myUserDetails);
        return "member/memberList";
    }

    // Detail
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model,
                         @AuthenticationPrincipal MyUserDetails myUserDetails){

        MemberDto member=memberService.detailMember(id);

        model.addAttribute("member", member);
        model.addAttribute("myUserDetails", myUserDetails);

        return "member/detail";
    }

    // Update







}
