package com.wh;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wh.mapper.FilmMapper;
import com.wh.mapper.StudentsMapper;
import com.wh.mapper.TeachersMapper;
import com.wh.pojo.Film;
import com.wh.pojo.Students;
import com.wh.pojo.Teachers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SpringBootDemo
 * @description: TeachetsTest
 * @author: wangheng
 * @create: 2022-07-20 16:17
 **/
@SpringBootTest
@RunWith(SpringRunner.class)// 测试类的运行环境
@AutoConfigureMockMvc//让当前类支持mockMvc
@SuppressWarnings("ALL")
public class TeachetsTest {
    @Autowired
    private TeachersMapper teachersMapper;
    @Autowired
    private StudentsMapper studentsMapper;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    /**
     * 测试类 1. 实现查询单个老师，带学生集合
     */
    public void  findTeacherById() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/teachers/findTeacherById/1");

        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
    /**
     * 测试类 2. 实现查询学生，带单个老师名称
     */
    @Test
    public void  finStudentsAll() throws Exception {

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/students/finStudentsAll");

        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
    /**
     * 测试类 3. 添加老师信息同时携带学生集合，级联添加（老师一条sql完成，学生使用批量添加要使用动态SQL）
     */
    @Test
    public void  addTeacher() throws Exception {
        //设置添加参数
        Students students=new Students("王恒学生",12);
        Students students1=new Students("王恒学生1",12);
        Students students2=new Students("王恒学生2",12);
        List<Students> list=new ArrayList<>();
        list.add(students);
        list.add(students1);
        list.add(students2);
        Teachers teachers=new Teachers();
        teachers.setName("王恒老师");
        teachers.setStudents(list);
        teachers.setAge(20);
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/teachers/addTeacher");
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(teachers));

        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }



}
