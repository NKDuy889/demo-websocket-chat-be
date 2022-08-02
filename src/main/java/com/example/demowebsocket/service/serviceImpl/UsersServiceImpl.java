package com.example.demowebsocket.service.serviceImpl;

import com.example.demowebsocket.model.Users;
import com.example.demowebsocket.repository.UsersRepository;
import com.example.demowebsocket.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UsersServiceImpl implements UsersService<Users> {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void test(){
       try {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Enter name: ");
           String a = scanner.next();
           System.out.println("Enter number: ");
           Integer b = scanner.nextInt();
           System.out.println(a + "asdasd" + b);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a > 0 ) {
            System.out.println("n is a positive number");
        } else if (a < 0) {
            System.out.println("n is a negative number");
        } else {
            System.out.println("n is equal to 0");
        }
    }
}
