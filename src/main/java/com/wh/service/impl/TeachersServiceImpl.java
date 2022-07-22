package com.wh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wh.entity.PageResult;
import com.wh.entity.Result;
import com.wh.mapper.StudentsMapper;
import com.wh.mapper.TeachersMapper;
import com.wh.pojo.Students;
import com.wh.pojo.Teachers;
import com.wh.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringBootDemo
 * @description: TeachersServiceImpl
 * @author: wangheng
 * @create: 2022-07-20 16:37
 **/
@Service
@SuppressWarnings("ALL")
@Transactional
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
    public Result addTeacher(Teachers teachers) {
        try {
            teachers.setCreateTime(new Date());
            teachers.setUpdateTime(new Date());
            teachersMapper.insertSelective(teachers);
            studentsMapper.addListStudents(teachers.getStudents(),teachers.getId());
            return new Result();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(1,"添加失败");
    }

    @Override
    public PageResult findTeacherList(Integer pageSize,Integer num, Map searchMap) {
        PageHelper.startPage(pageSize,num);
        List<Teachers> list=teachersMapper.findTeacherList(searchMap.get("name")+"");
        PageInfo pageInfo=new PageInfo(list);
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Result deleteTeacherById(Integer id) {
        try {
            //先删除教师下面对应的学生
            Students students=new Students();
            students.setTid(id);
            studentsMapper.delete(students);
            //在删除教师
            teachersMapper.deleteByPrimaryKey(id);
            return new Result();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(1,"删除失败");
    }

    @Override
    public Teachers findByIdteacher(Integer id) {
        return teachersMapper.findByIdteacher(id);
    }

    @Override
    public Result updateTeacher(Integer id, Teachers teachers) {
        try {
            teachers.setUpdateTime(new Date());
            //修改教师
            //先删除教师下面对应的学生
            Students students=new Students();
            students.setTid(id);
            studentsMapper.delete(students);
            //在修改教师信息
            teachersMapper.updateByPrimaryKeySelective(teachers);
            //在添加学生信息
            studentsMapper.addListStudents(teachers.getStudents(),id);
            return new Result();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(1,"修改失败");
    }
}
