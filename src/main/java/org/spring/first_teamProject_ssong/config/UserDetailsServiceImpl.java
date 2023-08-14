package org.spring.first_teamProject_ssong.config;

import org.apache.naming.factory.SendMailFactory;
import org.spring.first_teamProject_ssong.entity.MemberEntity;
import org.spring.first_teamProject_ssong.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        MemberEntity memberEntity=memberRepository.findByEmail(email).orElseThrow(()->{
           throw new UsernameNotFoundException("이메일이 없습니다");
        });

        return new MyUserDetails(memberEntity);
    }
}
