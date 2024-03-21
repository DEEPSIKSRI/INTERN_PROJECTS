package com.jsp.Job.repository.service;

import com.jsp.Job.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryServiceRepo {
    boolean existsCategoriesByCategory ( String categoryName );

    void save ( Category category );

    Long findByCategory( String category );

    void deleteById ( Long categoryId );

    List<Category> findTop10ByCategoryAsc();

    Optional < Category > findById ( Long category );
}