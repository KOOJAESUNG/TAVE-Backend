package com.tave;


import com.tave.constant.MemberType;
import com.tave.constant.NoticeType;
import com.tave.constant.ScoreType;
import com.tave.constant.TechField;
import com.tave.domain.admin.*;
import com.tave.domain.member.MemberEntity;
import com.tave.domain.team.TeamEntity;
import com.tave.repository.admin.*;
import com.tave.repository.member.MemberRepository;
import com.tave.repository.team.TeamRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Init {

    private final MemberRepository memberRepository;
    private final AdminRepository adminRepository;
    private final TeamRepository teamRepository;
    private final TeamScoreNoteRepository teamScoreNoteRepository;
    private final NoticeRepository noticeRepository;
    private final ScheduleRepository scheduleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostConstruct
    private void initFirst(){
        initAdmins();
        initTeams();
        initMembers();
        initTeamScoreNotes();
        initNotices();
        initSchedules();
    }

    @Transactional
    private void initAdmins() {
        for (int i = 0; i < 5; i++) {
            AdminEntity admin = new AdminEntity();
            admin.setUsername("admin_" + i);
            admin.setPassword(bCryptPasswordEncoder.encode("admin_" + i));
            admin.setEmail("admin" + i + "@tave.com");
            admin.setPhoneNumber("010-1234-5678 " + i);
            adminRepository.save(admin);
        }

    }

    @Transactional
    private void initTeams() {
        List<AdminEntity> admins = adminRepository.findAll();
            for (int i = 0; i < 5; i++) {
                TeamEntity team = new TeamEntity();
                team.setTeamName("Team" + i);
                team.setAdmin(admins.get(i));
                teamRepository.save(team);
            }

    }


    @Transactional
    private void initMembers() {
        List<TeamEntity> t = teamRepository.findAll();
            for (int i = 0; i < 5; i++) {

                MemberEntity m = new MemberEntity();
                m.setUsername("member" + i);
                m.setPassword(bCryptPasswordEncoder.encode("member" + i));
                m.setEmail("TAVE2023" + i + "@tave.com");
                m.setIntroduce("안녕하세요." + i);
                m.setName("김민지" + i);
                m.setProfileImage("이미지" + i);
                m.setRad(1 + i);
                m.setPhoneNumber("010-0000-0000 " + i);
                m.setTechField(TechField.APP);
                m.setMemberType(MemberType.YB);
                m.setUniversity("TAVE대학교" + i);
                m.setTeam(t.get(i));
                memberRepository.save(m);
            }

    }

    private void initTeamScoreNotes() {
        List<TeamEntity> t = teamRepository.findAll();
        for (int i = 0; i < 5; i++) {

            TeamScoreNoteEntity n = new TeamScoreNoteEntity();
            n.setNote("Note " + i);
            n.setScore(i);
            n.setScoreType(ScoreType.BASICSCORE);
            n.setTeam(t.get(i));
            teamScoreNoteRepository.save(n);
        }
    }

    private void initSchedules() {
        List<AdminEntity> a = adminRepository.findAll();
        for (int i = 0; i < 5; i++) {
            ScheduleEntity s = new ScheduleEntity();
            s.setDate(LocalDate.now());
            s.setPlace("강남" + i);
            s.setTitle("Title" + i);
            s.setAdmin(a.get(i));
            scheduleRepository.save(s);
        }
    }

    private void initNotices() {
        List<AdminEntity> a = adminRepository.findAll();
        for (int i = 0; i < 5; i++) {
            NoticeEntity n = new NoticeEntity();
            n.setContent("Notice content " + i);
            n.setAdmin(a.get(i));
            n.setNoticeType(NoticeType.NEWS);
            noticeRepository.save(n);
        }
    }






}