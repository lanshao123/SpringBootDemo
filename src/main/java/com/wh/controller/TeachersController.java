package com.wh.controller;

import com.wh.entity.PageResult;
import com.wh.entity.Result;
import com.wh.pojo.Teachers;
import com.wh.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: SpringBootDemo
 * @description: TeachersController
 * @author: wangheng
 * @create: 2022-07-20 16:36
 **/
@RestController
@RequestMapping("teachers")
@SuppressWarnings("All")
@CrossOrigin
public class TeachersController {
    @Autowired
    private TeachersService teachersService;

    /**
     * 分页查询教师信息
     * @param pageSize 当前页码
     * @param num 每页显示条数
     * @param searchMap 查询参数
     * @return 返回分页数据和总记录数
     */
    @PostMapping("/findTeacherList/{pageSize}/{num}")
    public PageResult findTeacherList(@PathVariable Integer pageSize, @PathVariable Integer num, @RequestBody Map searchMap){
       return teachersService.findTeacherList(pageSize,num,searchMap);
    }

    /**
     * 添加老师信息
     * @param teachers 老师对象 包含 学生集合
     * @return
     */
    @PostMapping("addTeacher")
    public Result addTeacher(@RequestBody Teachers teachers){
        return teachersService.addTeacher(teachers);

    }

    /**
     * 根据老师id 查询老师信息
     * @param id 老师id 主键
     * @return
     */
    @GetMapping("/findByIdteacher/{id}")
    public Teachers findByIdteacher(@PathVariable Integer id){
        return teachersService.findByIdteacher(id);
    }
    /**
     * 根据id删除教师
     * @param id 教师id
     * @return 返回结果对象
     */
    @DeleteMapping("deleteTeacherById/{id}")
    public Result deleteTeacherById(@PathVariable Integer id){
        return teachersService.deleteTeacherById(id);
    }

    /**
     * 修改教师信息 带修改学生集合信息
     * @param id 教师id
     * @param teachers 教师对象
     * @return
     */
    @PutMapping("/updateTeacher/{id}")
    public Result updateTeacher(@PathVariable Integer id, @RequestBody Teachers teachers){
        return teachersService.updateTeacher(id,teachers);
    }

}
