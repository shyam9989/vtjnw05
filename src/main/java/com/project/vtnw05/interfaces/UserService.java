package com.project.vtnw05.interfaces;

import com.project.vtnw05.DTO.UserDTO;
import com.project.vtnw05.exception.UserException;

public interface UserService  {

    public UserDTO register(UserDTO userDTO);
    public UserDTO login(String emailid, String password) throws UserException;

}