package com.angenin.springboot.service.impl;

import com.angenin.springboot.dao.UserDAO;
import com.angenin.springboot.pojo.User;
import com.angenin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @package_name: com.angenin.springboot.service
 * @name: UserServiceImpl
 * @author: angenin
 * @dateTime: 2020/12/13 下午9:32
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public boolean isExist(String username, String password) {
        return userDAO.usernameAndPassword(username, password) != null;
    }
}
