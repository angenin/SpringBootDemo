package com.angenin.springboot.controller;


import com.angenin.springboot.pojo.Dept;
import com.angenin.springboot.pojo.Emp;
import com.angenin.springboot.service.DeptService;
import com.angenin.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @package_name: com.angenin.springboot.controller
 * @name: EmpController
 * @author: angenin
 * @dateTime: 2020/12/13 下午2:12
 **/
@Controller
public class EmpController {

    @Autowired
    EmpService empService;
    @Autowired
    DeptService deptService;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        //获取所有员工数据
        List<Emp> emps = empService.getEmps();
        //把获取的数据放到请求域中
        model.addAttribute("emps", emps);

        //thymeleaf默认会进行拼串
        //classpath:/templates/xxx 加上后缀 .html
        return "emp/list";
    }


    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有的部门并添加到model
        List<Dept> depts = deptService.getDepts();
        model.addAttribute("depts", depts);
        //来到添加页面
        return "emp/add";
    }


    //添加员工
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定（请求参数名必须和javaBean入参的对象里面的属性名相同）
    @PostMapping("/emp")
    public String addEmp(Emp emp){
        empService.save(emp);
        //redirect：表示重定向到一个地址
        //forward：表示转发到一个地址
        // /：代表当前项目路径
        //重定向到员工列表页面
        return "redirect:/emps";
    }


    //来到修改页面，查出当前员工信息，然后在页面回显数据
    @GetMapping("/emp/{id}")    //@PathVariable：路径变量
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Emp Emp = empService.getEmp(id);
        model.addAttribute("emp", Emp);
        //查出所有的部门并添加到model
        List<Dept> Depts = deptService.getDepts();
        model.addAttribute("depts", Depts);

        //跳转到修改页面
        return "emp/update";
    }


    //员工修改，需要提交员工id
    @PutMapping("/emp")
    public String updateEmp(Emp emp){
        //保存修改的数据
        empService.update(emp);
        return "redirect:/emps";
    }


    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        //删除员工
        empService.delete(id);
        //重定向会list页面
        return "redirect:/emps";
    }
}