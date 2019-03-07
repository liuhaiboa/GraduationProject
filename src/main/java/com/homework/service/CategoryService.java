package com.homework.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.homework.entity.Category;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author haibo
 * @since 2018-11-19
 */
public interface CategoryService extends IService<Category> {

    void join(IPage<Map<String, Object>> pageData, String category_id);
}
