package com.wh.service;

import com.wh.entity.PageResult;
import com.wh.entity.Result;
import com.wh.pojo.Teachers;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public interface TeachersService {
    Teachers findTeacherById(Integer id);

    Result addTeacher(Teachers teachers);

    PageResult findTeacherList( Integer pageSize, Integer num, Map searchMap);

    Result deleteTeacherById(Integer id);

    Teachers findByIdteacher(Integer id);

    Result updateTeacher(Integer id, Teachers teachers);
}
