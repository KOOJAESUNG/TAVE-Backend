package com.tave.service.admin;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.dto.admin.AdminDto;
import com.tave.mapper.admin.AdminMapper;
import com.tave.repository.admin.AdminRepository;
import com.tave.repository.team.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    //회원가입을 안하기 때문에 create는 없음
    public AdminDto.AdminResponseDto getAdmin(Long adminId) {
        return adminMapper.toResponseDto(adminRepository.findById(adminId).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public AdminDto.AdminResponseDto updateAdmin(AdminDto.AdminPatchDto adminPatchDto) {
        AdminEntity adminEntity = adminRepository.findById(adminPatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        //update
        adminEntity.updateFromPatchDto(adminPatchDto);
        //entity->dto, return
        return adminMapper.toResponseDto(adminRepository.findById(adminPatchDto.getId()).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
        log.info("AdminEntity Id: {} is deleted", adminId);
    }
}
