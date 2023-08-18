package org.spring.first_teamProject_ssong.entity;

import lombok.*;
import org.spring.first_teamProject_ssong.constraint.Role;
import org.spring.first_teamProject_ssong.dto.MemberDto;
import org.spring.first_teamProject_ssong.utils.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "member_project")
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId; // member_id로 쓸지 memberId로 쓸지 정하기

    @Column(name = "member_email", unique = true, nullable = false)
    private String memberEmail;

    @Column(name = "member_password", nullable = false)
    private String memberPassword;

    // 본인 이름
    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "member_nickName", unique = true, nullable = false)
    private String memberNickName;

    // 휴대전화번호
    @Column(name = "member_phone", nullable = false)
    private String memberPhone;

    // 생년월일
    @Column(name = "member_birth", nullable = false)
    private String memberBirth;

    // 주소
    @Column(name = "member_address", nullable = false)
    private String memberAddress;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static MemberEntity toMemberEntityInsert(MemberDto memberDto, PasswordEncoder passwordEncoder) {

        MemberEntity memberEntity=new MemberEntity();

        memberEntity.setMemberEmail(memberDto.getMemberEmail());
        memberEntity.setMemberPassword(passwordEncoder.encode(memberDto.getMemberPassword()));
        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberNickName(memberDto.getMemberNickName());
        memberEntity.setMemberPhone(memberDto.getMemberPhone());
        memberEntity.setMemberBirth(memberDto.getMemberBirth());
        memberEntity.setMemberAddress(memberDto.getMemberAddress());
        memberEntity.setRole(Role.MEMBER);

        return memberEntity;
    }
    public static MemberEntity toMemberEntityUpdate(MemberDto memberDto) {

        MemberEntity memberEntity=new MemberEntity();

        memberEntity.setMemberId(memberDto.getMemberId());
        memberEntity.setMemberEmail(memberDto.getMemberEmail());
        memberEntity.setMemberPassword(memberDto.getMemberPassword());
        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberNickName(memberDto.getMemberNickName());
        memberEntity.setMemberPhone(memberDto.getMemberPhone());
        memberEntity.setMemberBirth(memberDto.getMemberBirth());
        memberEntity.setMemberAddress(memberDto.getMemberAddress());
        memberEntity.setRole(memberDto.getRole());
        memberEntity.setCreateTime(memberDto.getCreateTime());
        memberEntity.setUpdateTime(memberDto.getUpdateTime());

        return memberEntity;
    }


}
