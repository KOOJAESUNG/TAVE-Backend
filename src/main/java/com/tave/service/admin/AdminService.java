package com.tave.service.admin;

import com.tave.domain.admin.AdminEntity;
import com.tave.dto.admin.AdminDto;
import com.tave.exception.BusinessLogicException;
import com.tave.exception.ExceptionCode;
import com.tave.mapper.admin.AdminMapper;
import com.tave.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //회원가입을 안하기 때문에 create는 없음
//    public AdminDto.AdminResponseDto createAdmin(AdminDto.AdminPostDto adminPostDto) {
//        return adminMapper.toResponseDto(adminRepository.save(adminMapper.toEntity(adminPostDto)));
//    }

    public AdminDto.AdminResponseDto getAdmin(Long adminId) {
        return adminMapper.toResponseDto(adminRepository.findById(adminId)
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.ADMIN_NOT_FOUND)));
    }

    @Transactional
    public AdminDto.AdminResponseDto updateAdmin(Long adminId,AdminDto.AdminPatchDto adminPatchDto) {
        AdminEntity adminEntity = adminRepository.findById(adminId)
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.ADMIN_NOT_FOUND));
        //update
        if(adminPatchDto.getPassword()!=null) adminPatchDto.setPassword(bCryptPasswordEncoder.encode(adminPatchDto.getPassword()));
        adminMapper.updateFromPatchDto(adminPatchDto,adminEntity);
        //entity->dto, return
        return adminMapper.toResponseDto(adminRepository.findById(adminId)
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.UPDATE_FAIL_ADMIN)));
    }

    @Transactional
    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
        log.info("AdminEntity Id: {} is deleted", adminId);
    }
}
