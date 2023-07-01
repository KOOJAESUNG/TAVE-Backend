package com.tave;


import com.tave.constant.MemberType;
import com.tave.constant.TechField;
import com.tave.domain.admin.AdminEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.domain.team.TeamScoreNoteEntity;
import com.tave.repository.admin.AdminRepository;
import com.tave.repository.member.MemberRepository;
import com.tave.repository.team.TeamRepository;
import com.tave.repository.team.TeamScoreNoteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init {

    private final MemberRepository memberRepository;
    private final AdminRepository adminRepository;
    private final TeamRepository teamRepository;
    private final TeamScoreNoteRepository teamScoreNoteRepository;
    @PostConstruct
    @Transactional
    public void memberInit() {
        memberRepository.save(new MemberEntity());
        memberRepository.save(new MemberEntity());
        memberRepository.save(new MemberEntity());
        memberRepository.save(new MemberEntity());
        memberRepository.save(new MemberEntity());
        memberRepository.save(new MemberEntity());
    }

    @PostConstruct
    @Transactional
    public void adminInit() {
        adminRepository.save(new AdminEntity());
        adminRepository.save(new AdminEntity());
        adminRepository.save(new AdminEntity());
        adminRepository.save(new AdminEntity());
        adminRepository.save(new AdminEntity());
        adminRepository.save(new AdminEntity());
    }

    @PostConstruct
    @Transactional
    public void teamInit() {
        TeamEntity teamEntity = new TeamEntity();
        teamRepository.save(teamEntity);

        TeamScoreNoteEntity t1 = new TeamScoreNoteEntity();
        t1.setScore(5);
        t1.setTeam(teamEntity);
        teamScoreNoteRepository.save(t1);
        TeamScoreNoteEntity t2 = new TeamScoreNoteEntity();
        t2.setScore(5);
        t2.setTeam(teamEntity);
        teamScoreNoteRepository.save(t2);
        TeamScoreNoteEntity t3 = new TeamScoreNoteEntity();
        t3.setScore(5);
        t3.setTeam(teamEntity);
        teamScoreNoteRepository.save(t3);
        TeamScoreNoteEntity t4 = new TeamScoreNoteEntity();
        t4.setScore(5);
        t4.setTeam(teamEntity);
        teamScoreNoteRepository.save(t4);
        TeamScoreNoteEntity t5 = new TeamScoreNoteEntity();
        t5.setScore(5);
        t5.setTeam(teamEntity);
        teamScoreNoteRepository.save(t5);
    }

}
