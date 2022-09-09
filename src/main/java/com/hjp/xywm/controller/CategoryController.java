package com.hjp.xywm.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjp.xywm.common.R;
import com.hjp.xywm.entity.Category;
import com.hjp.xywm.entity.Employee;
import com.hjp.xywm.service.CategoryService;
import com.hjp.xywm.service.impl.CategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    //新增分类
    @PostMapping
    public R<String> save(@RequestBody Category category){
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    //菜品分类分页查询
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize){
        log.info("传入的page是{},传入的pageSize是{}",page,pageSize);
        //构造分页构造器
        Page pageInfo=new Page(page,pageSize);
        //构造条件构造器
        LambdaQueryWrapper<Category> queryWrapper=new LambdaQueryWrapper();
        //添加过滤条件
        //queryWrapper.like(!StringUtils.isEmpty(name),Employee::getName,name);
       queryWrapper.orderByAsc(Category::getSort);
        //添加排序条件
        queryWrapper.orderByDesc(Category::getUpdateTime);

        //执行查询
        categoryService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }
    //删除菜品分类
    @DeleteMapping
    public R<String> delete(Long ids){
        categoryService.remove(ids);
        return R.success("成功删除");
    }
    //修改分类
    @PutMapping
    public R<String> update(@RequestBody Category category){
        categoryService.updateById(category);
        return R.success("修改成功");
    }
}
