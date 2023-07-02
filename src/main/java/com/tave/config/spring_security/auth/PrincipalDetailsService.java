package com.tave.config.spring_security.auth;


import com.tave.domain.admin.AdminEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.repository.admin.AdminRepository;
import com.tave.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

	private final MemberRepository memberRepository;
	private final AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("PrincipalDetailsService : 진입");

		if (username.contains("admin_")) {
			AdminEntity adminEntity = adminRepository.findByUsername(username);

			// session.setAttribute("loginUser", user);
			return new PrincipalDetails(adminEntity);
		} else {
			MemberEntity memberEntity = memberRepository.findByUsername(username);

			// session.setAttribute("loginUser", user);
			return new PrincipalDetails(memberEntity);
		}
	}
}
