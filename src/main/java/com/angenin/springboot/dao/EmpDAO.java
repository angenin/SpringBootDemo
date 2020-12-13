package com.angenin.springboot.dao;

import com.angenin.springboot.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @package_name: com.angenin.springboot.dao
 * @name: EmpDAO
 * @author: angenin
 * @dateTime: 2020/12/13 下午5:32
 **/
public interface EmpDAO {

    List<Emp> getAll();

    Emp getEmpById(Integer id);

    void save(Map<String, Object> map);

    void update(Map<String, Object> map);

    void deleteEmpById(Integer id);
}
