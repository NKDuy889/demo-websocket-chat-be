package com.example.demowebsocket.service.serviceImpl;

import com.example.demowebsocket.model.Users;
import com.example.demowebsocket.repository.UsersRepository;
import com.example.demowebsocket.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService<Users> {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
