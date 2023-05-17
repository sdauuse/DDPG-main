package com.miao.dao;

import com.miao.pojo.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long> {//操作哪个表，表的主键的类型

}
