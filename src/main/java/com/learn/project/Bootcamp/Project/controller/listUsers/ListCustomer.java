package com.learn.project.Bootcamp.Project.controller.listUsers;

import com.learn.project.Bootcamp.Project.model.Users.Customer;
import com.learn.project.Bootcamp.Project.model.Users.User;
import com.learn.project.Bootcamp.Project.repository.CustomerRepository;
import com.learn.project.Bootcamp.Project.repository.UserRepository;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Where(clause = "is_active=true")
@RestController
public class ListCustomer {

    @Autowired
    CustomerRepository userRepository;

    @GetMapping("/viewCustomers")
    public List<Customer> getCustomer(){
        System.out.println("Hello");
        return userRepository.findAllCustomers();
    }






}
