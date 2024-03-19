package com.jsp.Job.api;

import com.jsp.Job.dto.JobVacancyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Job;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public interface JobApi {

    @PostMapping("/saveJob")
    ResponseEntity < ResponseDTO > saveJobVacancy ( @Valid @RequestBody Job job );

    @PostMapping("/addJobVacancy")
    ResponseEntity < ResponseDTO > jobVacancy ( @Valid @RequestBody JobVacancyDTO jobVacancyDTO );

    @GetMapping("/listOfJobVacancy")
    ResponseEntity < ResponseDTO > listOfJobVacancy ( );

    @GetMapping("/particularCompanyByName/{companyName}")
    ResponseEntity < ResponseDTO > particularCompany ( @PathVariable String companyName );

    @GetMapping("/searchByTitle/{occupationTittle}")
    ResponseEntity < ResponseDTO > searchByTitle ( @PathVariable String occupationTittle );

    @GetMapping("/searchByCategory/{category}")
    ResponseEntity < ResponseDTO > searchByCategory ( @PathVariable String category );

    @GetMapping("/searchByCompanyNameAndTitle")
    ResponseEntity < ResponseDTO > searchByCompanyNameAndTitle ( @RequestBody JobVacancyDTO jobVacancyDTO );


}