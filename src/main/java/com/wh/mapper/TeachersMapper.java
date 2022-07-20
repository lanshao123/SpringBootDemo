package com.wh.mapper;

import com.wh.pojo.Teachers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeachersMapper extends tk.mybatis.mapper.common.Mapper<Teachers> {
    Teachers findTeacherById(@Param("id")Integer id);
}
