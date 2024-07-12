package com.SMM.FoodOrdering.Service.Interface;

import com.SMM.FoodOrdering.Model.Company;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CompanyService {
    Company createCompany(Company company, MultipartFile logoFile)throws IOException;

    List<Company> getAllCompanies();
    Company updateCompany(Long companyId, Map<String, Object> fieldsToUpdate);

}
