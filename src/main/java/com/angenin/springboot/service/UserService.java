package com.angenin.springboot.service;

import org.springframework.stereotype.Service;

/**
 * @package_name: com.angenin.springboot.service
 * @name: UserService
 * @author: angenin
 * @dateTime: 2020/12/13 下午9:32
 **/
public interface UserService {
    boolean isExist(String username, String password);
}
