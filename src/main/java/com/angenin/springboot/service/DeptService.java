package com.angenin.springboot.service;

import com.angenin.springboot.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package_name: com.angenin.springboot.service
 * @name: DempService
 * @author: angenin
 * @dateTime: 2020/12/13 下午5:33
 **/
public interface DeptService {
    List<Dept> getDepts();
}
