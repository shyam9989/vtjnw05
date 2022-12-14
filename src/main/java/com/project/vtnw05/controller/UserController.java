package com.project.vtnw05.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vtnw05.DTO.APIResponse;
import com.project.vtnw05.DTO.UserDTO;
import com.project.vtnw05.exception.UserException;
import com.project.vtnw05.interfaces.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired UserService userService;

    @PostMapping("/user")
    public ResponseEntity<APIResponse> userRegister(
        @RequestBody @Valid UserDTO userDTO
    ) {

       UserDTO ud= userService.register(userDTO);
        APIResponse<UserDTO> responseDto = APIResponse
            .<UserDTO> builder()
            .status("success")
            .results(ud)
            .build();
        log.info(
            "UserController::userRegister response {}",
            ValueMapper.jsonAsString(responseDto)
        );
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }

    @PostMapping("/userlogin")
   public ResponseEntity<APIResponse> userLogin(String emailid,String password) throws UserException{

    UserDTO userDTO= userService.login(emailid, password);

    APIResponse<UserDTO> responseDto=APIResponse.<UserDTO> builder()
    .status("success")
    .results(userDTO)
    .build();

    return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);


   } 

}
