package com.wh.controller;

import com.wh.pojo.Teachers;
import com.wh.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: SpringBootDemo
 * @description: TeachersController
 * @author: wangheng
 * @create: 2022-07-20 16:36
 **/
@RestController
@RequestMapping("teachers")
@SuppressWarnings("All")
public class TeachersController {
    @Autowired
    private TeachersService teachersService;

    @GetMapping("/findTeacherById/{id}")
    public Teachers  findTeacherById(@PathVariable Integer id){
       return teachersService.findTeacherById(id);
    }
    @PostMapping("addTeacher")
    public void addTeacher(@RequestBody Teachers teachers){
        teachersService.addTeacher(teachers);

    }

}
