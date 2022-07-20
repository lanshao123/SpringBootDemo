package com.wh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wh.pojo.Film;
import com.wh.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: SpringBootDemo
 * @description: FilmController
 * @author: wangheng
 * @create: 2022-07-18 16:46
 **/
@Controller
public class FilmController {
    @Autowired
    private FilmService filmService;

    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping("show")
    public String show(Model model, @RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "1", required = false) Integer pageSize) {
        PageInfo<Film> pageInfo = filmService.selectAll(name, pageSize);
        model.addAttribute("list", pageInfo.getList());
        model.addAttribute("isIsFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("isIsLastPage", pageInfo.isIsLastPage());
        model.addAttribute("name", name);
        model.addAttribute("NextPage", "/show?pageSize=" + pageInfo.getNextPage() + "&name=" + name);
        model.addAttribute("PrePage", "/show?pageSize=" + pageInfo.getPrePage() + "&name=" + name);
        return "show";
    }

    @RequestMapping("findFilmById/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        Film byId = filmService.findById(id);
        model.addAttribute("film", byId);
        return "update";
    }

    @RequestMapping("deleteById/{id}")
    public void deleteById(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        filmService.deleteById(id);
        response.sendRedirect("/show");

    }

    @RequestMapping("update")
    public void update(Film film, HttpServletResponse response) throws IOException {
        filmService.update(film);
        response.sendRedirect("/show");

    }

    @RequestMapping("insert")
    public void insert(Film film,HttpServletResponse response) throws IOException {
        filmService.insert(film);
        response.sendRedirect("/show");
    }
    @GetMapping("addInsert")
    public String addInsert(){
        return "insert";
    }


}
