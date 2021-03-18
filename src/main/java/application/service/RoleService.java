package application.service;

import application.model.Role;

import java.util.List;

public interface RoleService {
    public Role findById(Long id);

    public List<Role> findAll();

    public Role saveRole(Role role);

    public void deleteById(Long id);

    public Role update(Role role);
}
