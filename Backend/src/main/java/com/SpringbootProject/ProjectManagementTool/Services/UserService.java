package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User findUserProfileByJwt(String jwt ) throws Exception;

    User findUserByEmail(String email) throws Exception;
    User findUserByid(Long id) throws Exception;
    User updateUsersProjectSize(User user , int size) throws Exception;
}
