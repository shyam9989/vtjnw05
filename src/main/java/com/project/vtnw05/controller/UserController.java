package com.project.vtnw05.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vtnw05.DTO.APIResponse;
import com.project.vtnw05.DTO.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<APIResponse> userRegister(@RequestBody @Valid UserDTO userDTO){
        System.out.println("in post matoing");       
         UserDTO ud=new UserDTO();
        ud.setEmailId("user@gmail.com");
        ud.setGender("male");
        
        APIResponse<UserDTO> responseDto= APIResponse
           .<UserDTO>builder()
           .status("success")
           .results(ud)
           .build();

         return new ResponseEntity<>(responseDto,HttpStatus.CREATED); 

    }
    
}
