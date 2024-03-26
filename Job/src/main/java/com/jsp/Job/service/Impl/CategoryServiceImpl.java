package com.jsp.Job.service.Impl;

import com.jsp.Job.dto.CategoryDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Category;
import com.jsp.Job.repository.service.CategoryServiceRepo;
import com.jsp.Job.repository.service.CompanyServiceRep;
import com.jsp.Job.repository.service.JobServiceRepo;
import com.jsp.Job.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryServiceRepo categoryServiceRepo;
    private final CompanyServiceRep companyServiceRep;
    private final JobServiceRepo jobServiceRepo;

    @Override
    public ResponseEntity < ResponseDTO > saveCategory ( CategoryDTO categoryDTO ) {
        Category category = new Category ( );
        if ( categoryServiceRepo.existsCategoriesByCategory ( categoryDTO.getCategoryName ( ) ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Category is Already Exist!!" , categoryDTO.getCategoryName ( ) ) );
        }
        category.setCategory ( categoryDTO.getCategoryName ( ) );
        categoryServiceRepo.save ( category );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Added Category!!" , category ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > updateCategory ( CategoryDTO categoryDTO ) {
        if ( !categoryServiceRepo.existsCategoriesByCategory ( categoryDTO.getCategoryName ( ) ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Category is Not Found!!" , categoryDTO.getCategoryName ( ) ) );
        }
        Category category = new Category ( );
        category.setCategory ( categoryDTO.getCategoryName ( ) );
        categoryServiceRepo.save ( category );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Category is Updated Successfully!!" , "" ) );

    }

    @Override
    public ResponseEntity < ResponseDTO > deleteCategory ( String categoryName ) {
        if ( !categoryServiceRepo.existsCategoriesByCategory ( categoryName ) ) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST ).body ( new ResponseDTO ( false , HttpStatus.BAD_REQUEST , "Category is Not Found!!" , categoryName ) );
        }
        Long categoryId = categoryServiceRepo.findByCategory ( categoryName );
        categoryServiceRepo.deleteById ( categoryId );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "Category is Deleted Successfully!!" , "" ) );
    }

    @Override
    public ResponseEntity < ResponseDTO > listOfCategory ( ) {
        List < Category > categories = categoryServiceRepo.findTop10ByCategoryAsc ( );
        List < CategoryDTO > categoryDTOS = categories.stream ( )
                .map ( category ->
                {
                    CategoryDTO categoryDTO = new CategoryDTO ( );
                    categoryDTO.setCategoryName ( category.getCategory ( ) );
                    return categoryDTO;
                } ).toList ( );
        return ResponseEntity.status ( HttpStatus.OK ).body ( new ResponseDTO ( true , HttpStatus.OK , "List of Categories!!" , categoryDTOS ) );

    }
}