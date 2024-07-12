package com.SMM.FoodOrdering.Controller;

import com.SMM.FoodOrdering.DTO.DynamicCompanyUpdateRequest;
import com.SMM.FoodOrdering.Model.Company;
import com.SMM.FoodOrdering.Respository.CompanyRepo;
import com.SMM.FoodOrdering.Service.Interface.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping(path = "/Company")
    public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company,
                                                 @RequestParam(value = "logo", required = false) MultipartFile logoFile) throws IOException {

        Company savedCompany = companyService.createCompany(company, logoFile);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        List<Company> companyList = companyService.getAllCompanies();
        return new ResponseEntity<>(companyList, HttpStatus.OK);

    }


    @PatchMapping("/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long companyId,
                                                 @Valid @RequestBody DynamicCompanyUpdateRequest updateRequest) {
        Company updatedCompany = companyService.updateCompany(companyId, updateRequest.getFieldsToUpdate());
        return ResponseEntity.ok(updatedCompany);
    }



}
