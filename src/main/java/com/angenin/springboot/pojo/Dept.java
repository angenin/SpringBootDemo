package com.angenin.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("Dept")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
	private Integer id;
	private String name;

	public Dept(String name) {
		this.name = name;
	}
}
