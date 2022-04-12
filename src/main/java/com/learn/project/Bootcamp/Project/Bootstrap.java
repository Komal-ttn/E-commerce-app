package com.learn.project.Bootcamp.Project;


import com.learn.project.Bootcamp.Project.repository.UserRepository;
import com.learn.project.Bootcamp.Project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class Bootstrap implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private CustomerService customerService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        roleService.save(ROLE_ADMIN);
        roleService.save(ROLE_SELLER);
        roleService.save(ROLE_CUSTOMER);
        String email = "admin@gmail.com";
        if(userRepository.findByEmail(email) == null) {
            userService.createAdmin(new UserDTO(email, "Admin", "Admin", "Admin", "aDminn@123", true, 0));
        }

        Address sellerAddress = new Address("New ", "Delhi", "India", "F-226", 110018, "Labell");
        email = "seller@gmail.com";
        if(userRepository.findByEmail(email) == null) {
            sellerService.createSeller(new SellerDTO(email, "Seller", "Seller", "Seller", "seLler@123", true, 0, "19AAACH6301A1Z8", "9653490446", "SellerCompany", sellerAddress));
        }

        Set<Address> customerAddresses = new HashSet<>();
        customerAddresses.add(new Address("New Delhi", "Delhi", "India", "F-226", 110018, "Labell"));
        customerAddresses.add(new Address("Mumbai", "Delhi", "India", "F-226", 110018, "Labell"));
        email = "customer@gmail.com";
        if(userRepository.findByEmail(email) == null) {
            customerService.createCustomer(new CustomerDTO(email, "customer", "customer", "customer", "customeR@123", true, 0, "9764349046", customerAddresses));
        }



    }
}
