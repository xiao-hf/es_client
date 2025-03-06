package com.xiao.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.xiao.domain.User;

public interface UserMapper {
    User selectById(@Param("id")Integer id);

    List<User> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}