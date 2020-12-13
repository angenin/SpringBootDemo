package com.angenin.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @package_name: com.angenin.springboot.pojo
 * @name: User
 * @author: angenin
 * @dateTime: 2020/12/13 下午9:31
 **/
@Alias("User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
}
