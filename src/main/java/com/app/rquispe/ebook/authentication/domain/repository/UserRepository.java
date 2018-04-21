package com.app.rquispe.ebook.authentication.domain.repository;



import com.app.rquispe.ebook.authentication.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
