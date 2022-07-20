package com.wh.service;

import com.github.pagehelper.PageInfo;
import com.wh.pojo.Film;

import java.util.List;

public interface FilmService {
    PageInfo<Film> selectAll(String name, Integer pageSize);

    Film findById(Integer id);

    void deleteById(Integer id);

    void update(Film film);

    void insert(Film film);
}
