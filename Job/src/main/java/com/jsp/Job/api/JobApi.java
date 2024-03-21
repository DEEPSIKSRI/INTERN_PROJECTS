package com.jsp.Job.api;

import com.jsp.Job.dto.JobVacancyDTO;
import com.jsp.Job.dto.ResponseDTO;
import com.jsp.Job.entity.Job;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public interface JobApi {

    @PreAuthorize( "hasAnyRole('ADMIN')" )
    @PostMapping("/saveJob")
    ResponseEntity < ResponseDTO > saveJobVacancy ( @Valid @RequestBody Job job );
    @PreAuthorize( "hasAnyRole('ADMIN')" )
    @PostMapping("/addJobVacancy")
    ResponseEntity < ResponseDTO > jobVacancy ( @Valid @RequestBody JobVacancyDTO jobVacancyDTO );

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/listOfJobVacancy")
    ResponseEntity < ResponseDTO > listOfJobVacancy ( );

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/listOfJobByTitle")
    ResponseEntity<ResponseDTO> listOfJobByTittle();

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/particularCompanyByName/{companyName}")
    ResponseEntity < ResponseDTO > particularCompany ( @PathVariable String companyName );

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/searchByTitle/{occupationTittle}")
    ResponseEntity < ResponseDTO > searchByTitle ( @PathVariable String occupationTittle );

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/searchByCategory/{category}")
    ResponseEntity < ResponseDTO > searchByCategory ( @PathVariable String category );

    @PreAuthorize( "hasAnyRole('ADMIN','USER')" )
    @GetMapping("/searchByCompanyNameAndTitle")
    ResponseEntity < ResponseDTO > searchByCompanyNameAndTitle ( @RequestBody JobVacancyDTO jobVacancyDTO );


}