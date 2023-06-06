package com.tave.domain.admin;

import com.tave.domain.team.TeamEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class AdminEntity {

    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phoneNumber;

    @OneToMany(mappedBy = "admin")
    private List<TeamEntity> teams = new ArrayList<>();
}
