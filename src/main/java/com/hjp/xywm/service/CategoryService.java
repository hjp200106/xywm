package com.hjp.xywm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjp.xywm.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;

public interface CategoryService extends IService<Category> {

   public void remove(Long ids);
}
