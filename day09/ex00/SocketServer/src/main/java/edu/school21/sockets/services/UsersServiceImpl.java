package edu.school21.sockets.services;

import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UsersServiceImpl implements UsersService{

    private PasswordEncoder passwordEncoder;
    private UsersRepository usersRepository;


    public UsersServiceImpl(PasswordEncoder passwordEncoder, UsersRepository usersRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public void singUp(User user) {
        if (usersRepository.findByUserName(user.getClientName()).isPresent()) {

        }
        user.setClientPassword(passwordEncoder.encode(user.getClientPassword()));
        usersRepository.save(user);
    }
}
