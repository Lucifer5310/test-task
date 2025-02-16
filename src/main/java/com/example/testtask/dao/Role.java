package com.example.testtask.dao;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roles")
@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@SequenceGenerator(name = "roles_seq", sequenceName = "roles_seq", allocationSize = 1)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    private long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Users> users;

    public String name() {
        return null;
    }
}
