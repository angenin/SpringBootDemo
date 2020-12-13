package com.angenin.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("Emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	private Integer id;
    private String name;
    private String email;
    //1 male, 0 female
    private Integer gender;
    private Dept dept;
    private Date birth;

    public Emp(String name, String email, Integer gender, Dept dept, Date birth) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.dept = dept;
        this.birth = birth;
    }
}
