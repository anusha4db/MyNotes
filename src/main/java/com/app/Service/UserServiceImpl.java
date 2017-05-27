package com.app.Service;


import com.app.model.User;
import com.app.notes.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User registerNewUserAccount(User user) throws UsernameExistsException {

        if (usernameExist(user.getUsername())) {
            throw new UsernameExistsException(
                    "There is an account with that username: "
                            + user.getUsername());
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setPasswordConfirmation(user.getPasswordConfirmation());
        newUser.setRole("USER");
        return userRepository.save(newUser);

    }

    private boolean usernameExist(String username) {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            return true;
        }

        return false;
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
