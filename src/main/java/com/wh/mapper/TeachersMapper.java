package com.wh.mapper;

import com.wh.pojo.Teachers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeachersMapper extends tk.mybatis.mapper.common.Mapper<Teachers> {
    Teachers findTeacherById(@Param("id")Integer id);

    List<Teachers> findTeacherList(@Param("name") String name);

    Teachers findByIdteacher(@Param("id") Integer id);
}
