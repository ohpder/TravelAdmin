package cn.hnjdzy.traveladmin.service;

import cn.hnjdzy.traveladmin.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll(Integer pageNum, Integer pageSize);

    void delCategory(int[] ids);

    void saveCategory(Category category);

    Category getCategoryById(Integer cId);

    void updateCategory(Category category);
}
