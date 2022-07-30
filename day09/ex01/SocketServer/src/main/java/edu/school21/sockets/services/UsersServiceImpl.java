package edu.school21.sockets.services;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UsersServiceImpl implements UsersService {
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(JdbcTemplate template, PasswordEncoder passwordEncoder, UsersRepository usersRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public void signUp(User user) {
        user.setClientPassword(passwordEncoder.encode(user.getClientPassword()));
        usersRepository.save(user);
    }

    @Override
    public boolean signIn(String username, String password) {
        if (usersRepository.findByUserName(username).isPresent()) {
            User user = usersRepository.findByUserName(username).get();
            return passwordEncoder.matches(user.getClientPassword(), password);
        }
        return false;
    }

    @Override
    public void saveMessage(String message) {
        usersRepository.saveMessage(message);
    }

}
