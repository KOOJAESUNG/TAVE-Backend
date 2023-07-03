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

import java.util.ArrayList;
import java.util.List;

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
    public ScheduleDto.ScheduleResponseDto createSchedule(Long adminId, ScheduleDto.SchedulePostDto schedulePostDto) {
        AdminEntity adminEntity = adminRepository.findById(adminId).orElseThrow();
        return scheduleMapper.toResponseDto(scheduleRepository.save(scheduleMapper.toEntity(schedulePostDto, adminEntity)));
    }

    public ScheduleDto.ScheduleResponseDto getSchedule(Long scheduleId) {
        return scheduleMapper.toResponseDto(scheduleRepository.findById(scheduleId).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public ScheduleDto.ScheduleResponseDto updateSchedule(ScheduleDto.SchedulePatchDto schedulePatchDto) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(schedulePatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        scheduleMapper.updateFromPatchDto(schedulePatchDto, scheduleEntity);
        //entity->dto 후 return
        return scheduleMapper.toResponseDto(scheduleRepository.findById(schedulePatchDto.getId()).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
        log.info("ScheduleEntity Id: {} is deleted", scheduleId);
    }

    @Transactional
    public void addAttendanceMemberId(Long scheduleId, Long memberId) throws EntityNotFoundException {
        MemberEntity memberEntity = memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException("멤버가 존재하지 않습니다."));
        ScheduleEntity scheduleEntity = scheduleRepository.findById(scheduleId).orElseThrow(() -> new EntityNotFoundException("일정이 존재하지 않습니다."));

        scheduleEntity.addAttendanceMemberId(memberId);
        log.info("Member Id: {} is added in Schedule Id: {}", memberId, scheduleId);
    }

    @Transactional
    public List<ScheduleDto.ScheduleResponseDto> getAllSchedule() {

        List<ScheduleEntity> scheduleEntities = scheduleRepository.getAllSchedule();
        List<ScheduleDto.ScheduleResponseDto> scheduleResponseDtos = new ArrayList<>();

        for (ScheduleEntity scheduleEntity : scheduleEntities) {
            ScheduleDto.ScheduleResponseDto scheduleResponseDto = scheduleMapper.toResponseDto(scheduleEntity);
            scheduleResponseDtos.add(scheduleResponseDto);
        }

        return scheduleResponseDtos;
    }
}

