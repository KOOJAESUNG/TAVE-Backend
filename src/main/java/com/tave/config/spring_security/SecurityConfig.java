package com.tave.config.spring_security;

import com.tave.config.spring_security.jwt.JwtAuthenticationFilter;
import com.tave.config.spring_security.jwt.JwtAuthorizationFilter;
import com.tave.repository.admin.AdminRepository;
import com.tave.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity // 시큐리티 활성화 -> 기본 스프링 필터체인에 등록
public class SecurityConfig {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CorsConfig corsConfig;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = authenticationManager(http.getSharedObject(AuthenticationConfiguration.class));

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic(AbstractHttpConfigurer::disable)
                .addFilter(corsConfig.corsFilter())
                .addFilter(new JwtAuthenticationFilter(authenticationManager))
                .addFilter(new JwtAuthorizationFilter(authenticationManager, memberRepository, adminRepository))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/adminRole/**")
                        .hasAnyRole("ADMIN")
                        .requestMatchers("/memberRole/**")
                        .hasAnyRole("MEMBER")
                        .requestMatchers("/sse/**","/coolSms/**","/googleOtp/**")
                        .hasAnyRole("ADMIN","MEMBER")

//                        .requestMatchers("/admin/getAdmin")
//                        .hasAnyRole("ADMIN")
//                        .requestMatchers("/api/v1/user/**")
//                        // ROLE_은 알아서 붙여줌!!
//                        .hasAnyRole("MEMBER", "ADMIN")
//                        .requestMatchers("/api/v1/manager/**")
//                        .hasAnyRole("ADMIN")
//                        .requestMatchers("/api/v1/admin/**")
//                        .hasAnyRole("ADMIN")
                        .anyRequest().permitAll())
                .build();
    }
}
