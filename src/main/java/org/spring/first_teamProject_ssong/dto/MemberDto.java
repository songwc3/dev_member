package org.spring.first_teamProject_ssong.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.spring.first_teamProject_ssong.constraint.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberDto {

    private Long id;

    @NotBlank
    @Size(min = 10, max = 255)
    private String email;

    @NotBlank
    @Size(min = 8, max = 255)
    private String password;

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank
    @Size(min = 2, max = 15)
    private String nickName;

    @NotBlank
    @Size(min = 10, max = 11)
    private String phone;

    @NotBlank
    @Size(min = 8, max = 8)
    private String birth;

    @NotBlank
    private String address;

    private Role role;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;



}
