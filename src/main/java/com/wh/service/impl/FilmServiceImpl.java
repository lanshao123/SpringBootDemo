package com.wh.service.impl;

import com.wh.mapper.FilmMapper;
import com.wh.pojo.Film;
import com.wh.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

/**
 * @program: SpringBootDemo
 * @description: FilmServiceImpl
 * @author: wangheng
 * @create: 2022-07-18 16:45
 **/
@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
   private FilmMapper filmMapper;
    @Override
    public List<Film> selectAll() {
        return filmMapper.selectAll();
    }

    @Override
    public Film findById(Integer id) {
        return filmMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Integer id) {
         filmMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Film film) {
        filmMapper.updateByPrimaryKeySelective(film);
    }

    @Override
    public void insert(Film film) {
        filmMapper.insertSelective(film);
    }
}
