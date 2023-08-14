package org.spring.first_teamProject_ssong.entity;

import lombok.*;
import org.spring.first_teamProject_ssong.constraint.Role;
import org.spring.first_teamProject_ssong.utils.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private Long id;

    @Column(name = "member_email", unique = true, nullable = false)
    private String email;

    @Column(name = "member_password", nullable = false)
    private String password;

    // 본인 이름
    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_nickName", nullable = false)
    private String nickName;

    // 휴대전화번호
    @Column(name = "member_phone", nullable = false)
    private String phone;

    // 생년월일
    @Column(name = "member_birth", nullable = false)
    private String birth;

    // 주소
    @Column(name = "member_address", nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;



}
