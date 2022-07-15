package com.miao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miao.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
