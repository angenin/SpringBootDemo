package com.angenin.springboot;

import com.angenin.springboot.dao.DeptDAO;
import com.angenin.springboot.dao.EmpDAO;
import com.angenin.springboot.pojo.Dept;
import com.angenin.springboot.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBootCrudApplicationTests {

    @Autowired
    DeptDAO deptDAO;
    @Autowired
    EmpDAO empDAO;

    @Test
    void contextLoads() {
        for (Dept dept : deptDAO.getAll()) {
            System.out.println(dept);
        }

        System.out.println(deptDAO.getDeptById(1));
    }


    @Test
    void contextLoads2() {
//        for (Emp emp : empDAO.getAll()) {
//            System.out.println(emp);
//        }

//        System.out.println(empDAO.getEmpById(1));

//        Map<String, Object> map = new HashMap<>();
//        map.put("id", 6);
//        map.put("name", "小黑");
//        map.put("email", "666@qq.com");
//        map.put("gender", "1");
//        map.put("dId", "3");
//        map.put("birth", LocalDate.now());

//        empDAO.save(map);
//        empDAO.update(map);

        empDAO.deleteEmpById(6);
    }
}
