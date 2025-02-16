package com.example.testtask.service;

import com.example.testtask.dao.entity.Role;
import com.example.testtask.dao.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findById(long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role with ID " + id + " not found"));
    }

    public Role findByName(String name) {
        return (Role) roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Role with name '" + name + "' not found"));
    }
}
