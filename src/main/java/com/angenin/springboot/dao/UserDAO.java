package com.angenin.springboot.dao;

import com.angenin.springboot.pojo.User;

/**
 * @package_name: com.angenin.springboot.dao
 * @name: LoginDAO
 * @author: angenin
 * @dateTime: 2020/12/13 下午9:31
 **/
public interface UserDAO {

    User usernameAndPassword(String username, String password);

}
