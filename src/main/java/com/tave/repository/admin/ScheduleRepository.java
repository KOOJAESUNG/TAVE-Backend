package com.tave.repository.admin;

import com.tave.domain.admin.ScheduleEntity;
import com.tave.dto.admin.ScheduleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Long> {
    @Query("SELECT s FROM ScheduleEntity s")
    List<ScheduleEntity> getAllSchedule();

}
