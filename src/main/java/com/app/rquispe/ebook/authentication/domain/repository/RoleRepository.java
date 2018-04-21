package com.app.rquispe.ebook.authentication.domain.repository;


import com.app.rquispe.ebook.authentication.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByName(String name);
}
