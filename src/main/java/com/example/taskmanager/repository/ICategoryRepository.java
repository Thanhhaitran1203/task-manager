package com.example.taskmanager.repository;

import com.example.taskmanager.model.Category;
import com.example.taskmanager.model.TotalAmount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<Category,Long> {
    @Query(nativeQuery = true, value = "select c.name as nameCategory, sum(t.amount) as totalAmount from category c left join task t on c.id = t.category_id group by c.id;")
    Iterable<TotalAmount> getTotalAmount();

}
