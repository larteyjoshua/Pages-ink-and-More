package com.joshua.pim.Controller;

import com.joshua.pim.Model.Users;
import com.joshua.pim.Repository.UsersRepository;
import com.joshua.pim.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
        private final UsersService usersService;

        @Autowired
        UsersRepository repo;

        @Autowired
        public UsersController(UsersService service) {
            usersService = service;
        }

        //get all available users
        @GetMapping("/allusers")
        public Iterable<Users> getAllUsers() {
            return usersService.getAllUsers();
        }


        //add a user
        @PostMapping("/add")
        public String bulkyadd() {
            repo.save(new Users("Joshua", "larteyjoshua@gmail.com", "joshua"));
            return "new user created";
        }
        //register a user
        @PostMapping("/register")
        public Users registerUsers(@RequestBody Users users) throws Exception {
            return usersService.registerUsers(new Users(users.getUserName(), users.getEmail(), users.getPassword()));
        }
        //update a user
        @PutMapping(value = "/update")
        public boolean updateUser(@RequestBody Users users){
            return usersService.updateUsers(users);
        }
        // delete a user
        @DeleteMapping(value = "/delete/{userID}")
        public boolean deleteUser(@PathVariable Long userID){
            return usersService.deleteusers(userID);
        }

        //user login
        @PostMapping("/login")
        public Users loginUsers(@RequestBody Users users) throws Exception {
            return usersService.loginUsers(users);
        }


    }

