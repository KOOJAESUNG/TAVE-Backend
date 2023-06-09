package com.tave.service.admin;

import com.tave.dto.admin.AdminDto;
import com.tave.repository.admin.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class AdminService {

    private final AdminRepository adminRepository;

    //회원가입을 안하기 때문에 create는 없음
    public void getAdmin(Long adminId) {
        adminRepository.findById(adminId).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void updateAdmin(AdminDto.AdminPatchDto adminPatchDto) {
        //update

        //entity->dto, return
    }

    @Transactional
    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
        log.info("Entity Id: {} is deleted",adminId);
    }
}
