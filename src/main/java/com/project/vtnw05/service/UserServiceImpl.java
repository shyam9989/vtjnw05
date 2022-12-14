package com.project.vtnw05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vtnw05.DTO.UserDTO;
import com.project.vtnw05.Entity.User;
import com.project.vtnw05.Repository.UserRepository;
import com.project.vtnw05.controller.ValueMapper;
import com.project.vtnw05.exception.UserException;
import com.project.vtnw05.interfaces.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired UserRepository userRepository;

    @Override public UserDTO register(UserDTO userDTO) {

        log.info(
            "userservice :: register request{}",
            ValueMapper.jsonAsString(userDTO)
        );
        User user = ValueMapper.userDTOtoUserDao(userDTO);
        user = userRepository.save(user);
        log.info(
            "userservice :: register after insertion into DB{}"+
            ValueMapper.jsonAsString(user)
        );
        UserDTO userdt = ValueMapper.userDaoToUserDTO(user);
        log.info(
            "userservice :: register response after conversion to DTO{}",
            ValueMapper.jsonAsString(userdt)
        );
        return userdt;

    }

    @Override public UserDTO login(String emailid, String password) throws UserException  {

        UserDTO userDTO=null;
        try{
        User user= userRepository.findByEmailIdAndUserPassword(emailid,password);
        log.info("userServiceimpl :: user login {}" ,ValueMapper.jsonAsString(user));
         userDTO=ValueMapper.userDaoToUserDTO(user);
        log.info("userServiceimpl :: user login after Dto conversion {}" ,
        ValueMapper.jsonAsString(userDTO));
        }catch(Exception ex){
            log.error("Exception occurred while user login, Exception message {}", ex.getMessage());
            throw new UserException("Exception occurred while login ");
        }
        return userDTO;
    

}}
