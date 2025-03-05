package com.xiao.mapper;

import com.xiao.domain.Time;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Time record);

    int insertSelective(Time record);

    Time selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Time record);

    int updateByPrimaryKey(Time record);
}