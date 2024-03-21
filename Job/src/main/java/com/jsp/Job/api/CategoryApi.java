package com.jsp.Job.api;

import com.jsp.Job.dto.CategoryDTO;
import com.jsp.Job.dto.JobVacancyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Category;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@RestController
public interface CategoryApi {

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/listOfCategory")
    ResponseEntity<ResponseDTO> listOfCategory();

    @PreAuthorize ( "hasAnyRole('ADMIN')" )
    @PostMapping("/addCategory")
    ResponseEntity< ResponseDTO > addCategory( @Valid @RequestBody CategoryDTO categoryDTO );

    @PreAuthorize ( "hasAnyRole('ADMIN')" )
    @PutMapping("/updateCategory")
    ResponseEntity<ResponseDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO);

    @PreAuthorize ( "hasAnyRole('ADMIN')" )
    @DeleteMapping("/deleteCategory/{categoryName}")
    ResponseEntity<ResponseDTO> deleteCategory(@PathVariable String categoryName);


}