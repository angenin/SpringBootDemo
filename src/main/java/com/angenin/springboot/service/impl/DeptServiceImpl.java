package com.angenin.springboot.service.impl;

import com.angenin.springboot.dao.DeptDAO;
import com.angenin.springboot.pojo.Dept;
import com.angenin.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package_name: com.angenin.springboot.service
 * @name: DempServiceImpl
 * @author: angenin
 * @dateTime: 2020/12/13 下午5:36
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDAO deptDAO;

    @Override
    public List<Dept> getDepts() {
        return deptDAO.getAll();
    }
}
