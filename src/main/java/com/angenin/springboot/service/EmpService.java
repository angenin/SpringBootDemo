package com.angenin.springboot.service;

import com.angenin.springboot.pojo.Emp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @package_name: com.angenin.springboot.service
 * @name: EmpService
 * @author: angenin
 * @dateTime: 2020/12/13 下午5:33
 **/
public interface EmpService {
    void delete(Integer id);

    void save(Emp emp);

    void update(Emp emp);

    Emp getEmp(Integer id);

    List<Emp> getEmps();
}
