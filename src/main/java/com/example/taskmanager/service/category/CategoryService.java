package com.example.taskmanager.service.category;

import com.example.taskmanager.model.Category;
import com.example.taskmanager.model.TotalAmount;
import com.example.taskmanager.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService<Category>{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
    categoryRepository.deleteById(id);
    }

    @Override
    public Iterable<TotalAmount> getTotalAmount() {
        return categoryRepository.getTotalAmount();
    }
}
