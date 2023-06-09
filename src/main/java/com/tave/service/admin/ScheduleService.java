package com.tave.service.admin;

import com.tave.dto.admin.ScheduleDto;
import com.tave.repository.admin.ScheduleRepository;
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

    @Transactional
    public void createSchedule(ScheduleDto.SchedulePostDto schedulePostDto) {
        //dto->entity

        //update

        //entity->dto 후 return
    }

    public void getSchedule(Long ScheduleId) {

    }

    @Transactional
    public void updateSchedule(ScheduleDto.SchedulePatchDto schedulePatchDto) {
        //update

        //entity->dto 후 return
    }

    @Transactional
    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
        log.info("Entity Id: {} is deleted",scheduleId);
    }
}
