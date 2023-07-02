package com.tave.domain.admin;


import com.tave.constant.Type;
import com.tave.domain.TimeStamp;
import com.tave.domain.member.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class MemberScoreNoteEntity extends TimeStamp {
    @Id
    @Column(name = "memberscorenote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String note;

    private Integer score;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;


}
