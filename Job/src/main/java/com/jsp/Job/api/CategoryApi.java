package com.jsp.Job.api;

import com.jsp.Job.dto.CategoryDTO;
import com.jsp.Job.dto.JobVacancyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Category;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@RestController
public interface CategoryApi {

    @GetMapping("/listOfCategory")
    ResponseEntity<ResponseDTO> listOfCategory();

    @PostMapping("/addCategory")
    ResponseEntity< ResponseDTO > addCategory( @Valid @RequestBody CategoryDTO categoryDTO );

    @PutMapping("/updateCategory")
    ResponseEntity<ResponseDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO);

    @DeleteMapping("/deleteCategory/{categoryName}")
    ResponseEntity<ResponseDTO> deleteCategory(@PathVariable String categoryName);


}