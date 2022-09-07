package com.hjp.xywm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjp.xywm.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
