package com.kiry665.trainpass.Services;

import com.kiry665.trainpass.Models.Role;
import com.kiry665.trainpass.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
