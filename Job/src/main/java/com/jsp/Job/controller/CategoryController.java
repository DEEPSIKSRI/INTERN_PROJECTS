package com.jsp.Job.controller;

import com.jsp.Job.api.CategoryApi;
import com.jsp.Job.dto.CategoryDTO;
import com.jsp.Job.dto.JobVacancyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Category;
import com.jsp.Job.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity < ResponseDTO > listOfCategory ( ) {
        return categoryService.listOfCategory();
    }

    @Override
    public ResponseEntity < ResponseDTO > addCategory ( CategoryDTO categoryDTO ) {
        return categoryService.saveCategory(categoryDTO);
    }

    @Override
    public ResponseEntity < ResponseDTO > updateCategory ( CategoryDTO categoryDTO ) {
        return categoryService.updateCategory(categoryDTO);
    }

    @Override
    public ResponseEntity < ResponseDTO > deleteCategory ( String categoryName ) {
        return categoryService.deleteCategory(categoryName);
    }


}