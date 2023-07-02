package com.tave.domain.admin;

import com.tave.domain.TimeStamp;
import com.tave.domain.member.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Getter @Setter
public class ScheduleEntity extends TimeStamp {

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;
    private String place;
    private String title;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "schedule_attendance_member",
            joinColumns = @JoinColumn(name = "schedule_id")
    )
    @Column(name = "attendance_member_id")
    private Set<Long> attendanceMemberId = new TreeSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;


    public void addAttendanceMemberId(Long memberId) {
        this.attendanceMemberId.add(memberId);
    }
}
