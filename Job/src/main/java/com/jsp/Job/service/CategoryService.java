package com.jsp.Job.service;

import com.jsp.Job.dto.CategoryDTO;
import com.jsp.Job.dto.JobVacancyDTO;
import com.jsp.Job.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    ResponseEntity< ResponseDTO> saveCategory ( CategoryDTO categoryDTO );

    ResponseEntity< ResponseDTO> updateCategory ( CategoryDTO categoryDTO );

    ResponseEntity< ResponseDTO> deleteCategory ( String categoryName );

    ResponseEntity< ResponseDTO> listOfCategory ( );

}