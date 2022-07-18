package com.wh.controller;

import com.wh.pojo.Film;
import com.wh.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: SpringBootDemo
 * @description: FilmController
 * @author: wangheng
 * @create: 2022-07-18 16:46
 **/
@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("findAll")
    public List<Film> all(){
        return filmService.selectAll();
    }
    @RequestMapping("findById")
    public Film findById(Integer id){
        return filmService.findById(id);
    }
    @RequestMapping("deleteById")
    public void deleteById(Integer id){
         filmService.deleteById(id);
    }
    @RequestMapping("update")
    public void update(Film film){
        filmService.update(film);
    }
    @RequestMapping("insert")
    public void insert(Film film){
        filmService.insert(film);
    }
}
