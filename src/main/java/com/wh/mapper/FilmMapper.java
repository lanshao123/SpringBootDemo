package com.wh.mapper;

import com.wh.pojo.Film;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: SpringBootDemo
 * @description: FilmMapper
 * @author: wangheng
 * @create: 2022-07-18 16:41
 **/
@Mapper
@Component
public interface FilmMapper extends tk.mybatis.mapper.common.Mapper<Film> {
    List<Film> selectAlls();
}
