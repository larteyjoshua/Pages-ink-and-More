package com.joshua.pim.Service;

import com.joshua.pim.Model.Users;
import com.joshua.pim.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;



    @Autowired
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder ) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Iterable<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users registerUsers(Users users) {
        System.out.println(users.toString());
        if (usersRepository.findByEmail(users.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User already exist with email");
        }
        Users createdUser = usersRepository.save(hashPassword(users));
        return createdUser;
    }

    private Users hashPassword(Users users) {
        //encode password
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return users;
    }

    public Users loginUsers(Users users) {

        Optional<Users> foundUser = usersRepository.findByEmail(users.getEmail());

        if (foundUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
        }

        // compare password
        if (!passwordEncoder.matches(users.getPassword(), foundUser.get().getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect credentials");
        }

        return foundUser.get();
    }

    public boolean updateUsers (Users users){
        Iterable<Users> existingUser=usersRepository.findByUserID(users.getUserID());
        if(existingUser!=null){
            Users updateUser=usersRepository.save(new Users(users.getUserName(),users.getEmail(),users.getPassword()));
            if(updateUser!=null){
                return true;
            }
        }
        return false;
    }

    public boolean deleteusers (Long userID){
        Iterable<Users> existingUser=usersRepository.findByUserID(userID);
        if(existingUser!=null){
            usersRepository.deleteById(userID);
            return true;
        }
        return false;
    }
}
