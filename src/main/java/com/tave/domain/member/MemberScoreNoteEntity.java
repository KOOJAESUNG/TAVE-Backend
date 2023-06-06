package com.tave.domain.member;


import com.tave.constant.Type;
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
    @JoinColumn(name = "memberscore_id")
    private MemberScoreEntity memberScore;
}
