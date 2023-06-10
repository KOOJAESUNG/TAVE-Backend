package com.tave.domain.member;


import com.tave.constant.Type;
import com.tave.dto.member.MemberScoreNoteDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class MemberScoreNoteEntity {
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


    public void updateFromPatchDto(MemberScoreNoteDto.MemberScoreNotePatchDto memberScoreNotePatchDto) {
        this.note = memberScoreNotePatchDto.getNote();
        this.score = memberScoreNotePatchDto.getScore();
        this.type = Type.valueOf(memberScoreNotePatchDto.getType());
    }
}
