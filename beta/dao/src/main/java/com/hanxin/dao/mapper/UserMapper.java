package com.hanxin.dao.mapper;

import com.hanxin.dao.entity.UserDo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: hanxin
 * @Date: 2020/7/7 0:38
 * @Version 1.0
 */
@Repository
public interface UserMapper {

  @Select("select * from user_info where id = #{id}")
  @Results({
      @Result(property = "name", column = "name"),
      @Result(property = "age", column = "age")
  })
  UserDo getUser(String id);

  @Select("select * from user_info where id = #{id} and name=#{name}")
  UserDo getUserByIdAndName(@Param("id") String id, @Param("name") String name);

  List<UserDo> getAll();

  // 使用xml方式
  UserDo getUserByName(String name);

}
