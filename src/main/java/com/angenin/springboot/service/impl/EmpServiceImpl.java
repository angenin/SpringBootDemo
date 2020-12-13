package com.angenin.springboot.service.impl;

import com.angenin.springboot.dao.EmpDAO;
import com.angenin.springboot.pojo.Emp;
import com.angenin.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package_name: com.angenin.springboot.service
 * @name: EmpServiceImpl
 * @author: angenin
 * @dateTime: 2020/12/13 下午5:37
 **/
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpDAO empDAO;

    @Override
    public void delete(Integer id) {
        empDAO.deleteEmpById(id);
    }

    @Override
    public void save(Emp emp) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", emp.getName());
        map.put("email", emp.getEmail());
        map.put("gender", emp.getGender());
        map.put("dId", emp.getDept().getId());
        map.put("birth", emp.getBirth());

        empDAO.save(map);
    }

    @Override
    public void update(Emp emp) {
        Map<String, Object> map = new HashMap<>();
        if (emp.getId() != null) {
            map.put("id", emp.getId());
        }
        if (emp.getId() != null) {
            map.put("name", emp.getName());
        }
        if (emp.getId() != null) {
            map.put("email", emp.getEmail());
        }
        if (emp.getId() != null) {
            map.put("gender", emp.getGender());
        }
        if (emp.getId() != null) {
            map.put("dId", emp.getDept().getId());
        }
        if (emp.getId() != null) {
            map.put("birth", emp.getBirth());
        }

        empDAO.update(map);
    }

    @Override
    public Emp getEmp(Integer id) {
        return empDAO.getEmpById(id);
    }

    @Override
    public List<Emp> getEmps() {
        return empDAO.getAll();
    }
}
