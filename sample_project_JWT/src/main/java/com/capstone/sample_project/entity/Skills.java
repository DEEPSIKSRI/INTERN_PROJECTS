package com.capstone.sample_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SKILLS")

public class Skills {

    @Id
    @Column(name = "ID")
    @NotNull
    private int skillsId;

    @Column(name = "SKILL")
    private String skill;

    @Column(name = "EXPERIENCE")
    private String experience;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "USER_ID")
    private User userId;

}
