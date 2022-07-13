package com.miao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miao.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
