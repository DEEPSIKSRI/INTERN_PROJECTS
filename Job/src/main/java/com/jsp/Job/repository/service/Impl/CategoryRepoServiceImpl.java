package com.jsp.Job.repository.service.Impl;

import com.jsp.Job.entity.Category;
import com.jsp.Job.repository.CategoryRepository;
import com.jsp.Job.repository.service.CategoryServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryRepoServiceImpl implements CategoryServiceRepo {

    private final CategoryRepository categoryRepository;


    @Override
    public boolean existsCategoriesByCategory ( String categoryName ) {
        return categoryRepository.existsCategoriesByCategory ( categoryName );
    }

    @Override
    public void save ( Category category ) {
       categoryRepository.save ( category );
    }

    @Override
    public Long findByCategory ( String category ) {
        return categoryRepository.findByCategory ( category );
    }

    @Override
    public void deleteById ( Long categoryId ) {
     categoryRepository.deleteById ( categoryId );
    }

    @Override
    public List < Category > findTop10ByCategoryAsc ( ) {
        return categoryRepository.findTop10ByOrderByCategoryAsc ();
    }

    @Override
    public Optional < Category > findById ( Long category ) {
        return categoryRepository.findById ( category );
    }
}