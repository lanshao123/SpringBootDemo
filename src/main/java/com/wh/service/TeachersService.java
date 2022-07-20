package com.wh.service;

import com.wh.pojo.Teachers;

public interface TeachersService {
    Teachers findTeacherById(Integer id);

    void addTeacher(Teachers teachers);
}
