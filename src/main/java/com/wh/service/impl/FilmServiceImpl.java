package com.wh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wh.mapper.FilmMapper;
import com.wh.pojo.Film;
import com.wh.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

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
    public PageInfo<Film> selectAll(String name,Integer pageSize) {
        Example example=new Example(Film.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(name)){
            criteria.andLike("name","%"+name+"%");
        }
        PageHelper.startPage(pageSize,3);
        List<Film> films = filmMapper.selectByExample(example);

        return new PageInfo<Film>(films);
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
