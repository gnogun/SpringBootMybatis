package com.gno.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.gno.dto.UserT;

public interface UserMapper {

	@Insert("INSERT INTO userT values(#{name},#{password})")
	public void insertUser(UserT userT);
	
	@Select("SELECT * FROM userT where name = #{name}")
	public UserT selectByUserName(String name);
}
