package com.miao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miao.dto.SetmealDto;
import com.miao.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    public void saveWithDish(SetmealDto setmealDto);

    public void removeWithDish(List<Long> ids);
}
