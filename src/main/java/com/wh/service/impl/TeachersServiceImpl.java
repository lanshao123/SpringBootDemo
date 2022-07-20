package com.wh.service.impl;

import com.wh.mapper.StudentsMapper;
import com.wh.mapper.TeachersMapper;
import com.wh.pojo.Teachers;
import com.wh.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringBootDemo
 * @description: TeachersServiceImpl
 * @author: wangheng
 * @create: 2022-07-20 16:37
 **/
@Service
@SuppressWarnings("ALL")
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private TeachersMapper teachersMapper;
    @Autowired
    private StudentsMapper studentsMapper;
    @Override
    public Teachers findTeacherById(Integer id) {
        return teachersMapper.findTeacherById(id);
    }

    @Override
    public void addTeacher(Teachers teachers) {
        teachersMapper.insertSelective(teachers);
        studentsMapper.addListStudents(teachers.getStudents(),teachers.getId());
    }
}
