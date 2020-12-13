package com.angenin.springboot.dao;

import com.angenin.springboot.pojo.Dept;

import java.util.List;
import java.util.Map;

/**
 * @package_name: com.angenin.springboot.dao
 * @name: DeptDAO
 * @author: angenin
 * @dateTime: 2020/12/13 下午5:32
 **/
public interface DeptDAO {

    List<Dept> getAll();

    Dept getDeptById(Integer id);

}
