package com.project.vtnw05.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.vtnw05.DTO.UserDTO;
import com.project.vtnw05.Entity.User;

public class ValueMapper {

    public static User userDTOtoUserDao(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmailId(userDTO.getEmailId());
        user.setGender(userDTO.getGender());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setUserPassword(userDTO.getUserPassword());
        return user;

    }

    public static UserDTO userDaoToUserDTO(User user) {
        UserDTO userdt = new UserDTO();
       
        userdt.setUserName(user.getUserName());
        userdt.setEmailId(user.getEmailId());
        userdt.setGender(user.getEmailId());
        userdt.setMobileNumber(user.getMobileNumber());
        userdt.setUserPassword(user.getUserPassword());
        return userdt;

    }

    public static String jsonAsString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
