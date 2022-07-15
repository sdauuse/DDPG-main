package com.miao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miao.common.CustomException;
import com.miao.entity.Category;
import com.miao.entity.Dish;
import com.miao.entity.Setmeal;
import com.miao.mapper.CategoryMapper;
import com.miao.service.CategoryService;
import com.miao.service.DishService;
import com.miao.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除之前需要进行判断
     *
     * @param id
     */
    @Override
    public void remove(Long id) {
        //添加查询条件，根据分类id进行查询
        LambdaQueryWrapper<Dish> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(Dish::getCategoryId, id);
        //查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        int count1 = dishService.count(queryWrapper1);
        if (count1 > 0) {
            //已经关联菜品，抛出一个业务异常
            throw new CustomException("当前分类下关联了菜品，不能删除");

        }

        LambdaQueryWrapper<Setmeal> queryWrapper2 = new LambdaQueryWrapper();
        //添加查询条件，根据分类id进行查询
        queryWrapper2.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(queryWrapper2);
        //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        if (count2 > 0) {
            //已经关联套餐，抛出一个业务异常
            throw new CustomException("当前分类下关联了套餐，不能删除");

        }



        //正常删除分类
        super.removeById(id);
    }
}
