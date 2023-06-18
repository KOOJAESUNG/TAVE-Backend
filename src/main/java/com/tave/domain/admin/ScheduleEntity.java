package com.tave.domain.admin;

import com.tave.domain.member.MemberEntity;
import com.tave.dto.admin.ScheduleDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class ScheduleEntity {

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private String place;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;


    public void updateFromPatchDto(ScheduleDto.SchedulePatchDto schedulePatchDto) {
        if(schedulePatchDto.getPlace() !=null) this.place = place;
        if(schedulePatchDto.getTitle() !=null) this.title = title;
    }
}
