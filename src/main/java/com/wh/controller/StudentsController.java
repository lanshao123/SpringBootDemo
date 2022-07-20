package com.wh.controller;

import com.wh.pojo.Students;
import com.wh.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: SpringBootDemo
 * @description: StudentsController
 * @author: wangheng
 * @create: 2022-07-20 16:45
 **/
@RestController
@RequestMapping("students")
@SuppressWarnings("All")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping("finStudentsAll")
    public List<Students> finStudentsAll(){
        return studentsService.finStudentsAll();
    }
}
