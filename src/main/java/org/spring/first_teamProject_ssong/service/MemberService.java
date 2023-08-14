package org.spring.first_teamProject_ssong.service;

import lombok.RequiredArgsConstructor;
import org.spring.first_teamProject_ssong.constraint.Role;
import org.spring.first_teamProject_ssong.dto.MemberDto;
import org.spring.first_teamProject_ssong.entity.MemberEntity;
import org.spring.first_teamProject_ssong.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // Create
    @Transactional
    public void insertMember(MemberDto memberDto) {

        String email = memberRepository.save(MemberEntity.builder()
                .email(memberDto.getEmail())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .name(memberDto.getName())
                .nickName(memberDto.getNickName())
                .phone(memberDto.getPhone())
                .birth(memberDto.getBirth())
                .address(memberDto.getAddress())
                .role(Role.MEMBER)
                .build()).getEmail();
        memberRepository.findByEmail(email).orElseThrow(IllegalAccessError::new);
    }

    // Read
    public List<MemberDto> ListMember() {

        List<MemberDto> memberDtoList = new ArrayList<>();
        List<MemberEntity> memberEntityList = memberRepository.findAll();

        for (MemberEntity memberEntity : memberEntityList) {
            memberDtoList.add(MemberDto.builder()
                    .id(memberEntity.getId())
                    .email(memberEntity.getEmail())
                    .password(memberEntity.getPassword())
                    .name(memberEntity.getName())
                    .nickName(memberEntity.getNickName())
                    .phone(memberEntity.getPhone())
                    .birth(memberEntity.getBirth())
                    .address(memberEntity.getAddress())
                    .role(memberEntity.getRole())
                    .createTime(memberEntity.getCreateTime())
                    .updateTime(memberEntity.getUpdateTime())
                    .build());
        }
        return memberDtoList;
    }

    // Detail
    public MemberDto detailMember(Long id) {

        MemberEntity memberEntity = memberRepository.findById(id).orElseThrow(IllegalAccessError::new);

        return MemberDto.builder()
                .id(memberEntity.getId())
                .email(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .name(memberEntity.getName())
                .nickName(memberEntity.getNickName())
                .phone(memberEntity.getPhone())
                .birth(memberEntity.getBirth())
                .address(memberEntity.getAddress())
                .role(memberEntity.getRole())
                .createTime(memberEntity.getCreateTime())
                .updateTime(memberEntity.getUpdateTime())
                .build();
    }

    // Update


}
