package com.example.taskmanager.service.category;

import com.example.taskmanager.model.Category;
import com.example.taskmanager.model.TotalAmount;
import com.example.taskmanager.service.IGenerateService;

public interface ICategoryService<C> extends IGenerateService<Category> {
    Iterable<TotalAmount> getTotalAmount();
}
