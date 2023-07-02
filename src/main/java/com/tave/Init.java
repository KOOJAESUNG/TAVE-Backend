package com.tave;


import com.tave.domain.admin.AdminEntity;
import com.tave.domain.member.MemberEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.domain.admin.TeamScoreNoteEntity;
import com.tave.repository.admin.AdminRepository;
import com.tave.repository.member.MemberRepository;
import com.tave.repository.team.TeamRepository;
import com.tave.repository.admin.TeamScoreNoteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init {

    private final MemberRepository memberRepository;
    private final AdminRepository adminRepository;
    private final TeamRepository teamRepository;
    private final TeamScoreNoteRepository teamScoreNoteRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostConstruct
    @Transactional
    public void memberInit() {
        for (int i = 1; i <= 5; i++) {
            MemberEntity m = new MemberEntity();
            m.setUsername("member"+i);
            m.setPassword(bCryptPasswordEncoder.encode("member"+i));
            memberRepository.save(m);
        }
    }

    @PostConstruct
    @Transactional
    public void adminInit() {
        for (int i = 1; i <= 5; i++) {
            AdminEntity a = new AdminEntity();
            a.setUsername("admin_admin"+i);
            a.setPassword(bCryptPasswordEncoder.encode("admin_admin"+i));
            adminRepository.save(a);
        }
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
