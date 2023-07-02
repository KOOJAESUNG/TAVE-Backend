package com.tave.repository.admin;

import com.tave.domain.admin.NoticeEntity;
import com.tave.domain.admin.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity,Long> {
    @Query("SELECT n FROM NoticeEntity n")
    List<NoticeEntity> getAllNotice();
}
