package com.tave.service.admin;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.admin.ScheduleEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.dto.admin.ScheduleDto;
import com.tave.mapper.admin.ScheduleMapper;
import com.tave.repository.admin.AdminRepository;
import com.tave.repository.admin.ScheduleRepository;
import com.tave.repository.member.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;
    private final AdminRepository adminRepository;
    private final ScheduleMapper scheduleMapper;

    @Transactional
    public ScheduleDto.ScheduleResponseDto createSchedule(ScheduleDto.SchedulePostDto schedulePostDto) {
        MemberEntity memberEntity=null;
        AdminEntity adminEntity=null;
        if(schedulePostDto.getMemberId()!=null)
            memberEntity = memberRepository.findById(schedulePostDto.getMemberId()).orElseThrow();
        if(schedulePostDto.getAdminId()!=null)
            adminEntity = adminRepository.findById(schedulePostDto.getAdminId()).orElseThrow();

        return scheduleMapper.toResponseDto(scheduleRepository.save(scheduleMapper.toEntity(schedulePostDto,memberEntity,adminEntity)));
    }

    public ScheduleDto.ScheduleResponseDto getSchedule(Long scheduleId) {
        return scheduleMapper.toResponseDto(scheduleRepository.findById(scheduleId).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public ScheduleDto.ScheduleResponseDto updateSchedule(ScheduleDto.SchedulePatchDto schedulePatchDto) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(schedulePatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        //update
//        scheduleEntity.updateFromPatchDto(schedulePatchDto);
        scheduleMapper.updateFromPatchDto(schedulePatchDto,scheduleEntity);
        //entity->dto 후 return
        return scheduleMapper.toResponseDto(scheduleRepository.findById(schedulePatchDto.getId()).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
        log.info("ScheduleEntity Id: {} is deleted",scheduleId);
    }
}
