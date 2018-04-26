package com.app.rquispe.ebook.authentication.validator;

import com.app.rquispe.ebook.authentication.domain.model.User;
import com.app.rquispe.ebook.authentication.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
/*
 * you must be sure that the provided username doesn’t exist.
 */
@Component
public class NewUserValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User newUser = (User) target;
        if (userRepository.existsById(newUser.getUsername())) {
            errors.rejectValue("username", "new.account.username.already.exists");
        }
    }
}
