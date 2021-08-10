package com.example_appws.ui.controller;

import com.example_appws.service.UserService;
import com.example_appws.shared.dto.UserDto;
import com.example_appws.service.impl.UserServiceImpl;
import com.example_appws.ui.model.request.Userdeatailsrequestmodel;
import com.example_appws.ui.model.responce.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http//localhost:8080/users
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get user was called ";
    }


   @PostMapping
   public UserRest createuser(@RequestBody Userdeatailsrequestmodel userdetails){
       UserRest returnValue = new UserRest();
       UserDto userDTO = new UserDto();
       BeanUtils.copyProperties(userdetails , userDTO);
       UserDto createUser = userService.createUser(userDTO);
       BeanUtils.copyProperties(createUser,returnValue);
       return returnValue;

   }


   @PutMapping
   public String updateUser(){
        return "update user was called ";
   }
    @DeleteMapping
    public String deleteUser(){
        return "delete user was called ";
    }
}


