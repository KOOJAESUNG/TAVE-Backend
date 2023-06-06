package com.tave.dto;

//회원 가입 화면으로부터 넘어오는 가입정보를 담을 dto

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

//멤버 등록 시 DTO
@Getter
@Setter
public class MemberFormDto {

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
    private String password;

    private List<MemberFormDto> MemberFormDtoList = new ArrayList<>(); //수정 시 정보 저장 리스트

    private static ModelMapper modelMapper = new ModelMapper();
    
    public Member createMember(){
        return modelMapper.map(this, Member.class);
    }
    
    public static MemberFormDto of(Member member) {
        return modelMapper.map(member, MemberFormDto.class);
    } //modelMapper를 통해 엔티티객체와 DTO 객체 간의 데이터 복사하여 객체 반환해주는 메소드, dependency 추가
}
