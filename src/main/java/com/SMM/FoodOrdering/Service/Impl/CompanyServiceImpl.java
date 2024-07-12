package com.SMM.FoodOrdering.Service.Impl;

import com.SMM.FoodOrdering.Model.Company;
import com.SMM.FoodOrdering.Respository.CompanyRepo;
import com.SMM.FoodOrdering.Service.Interface.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public Company createCompany(Company company, MultipartFile logoFile) throws IOException {
        if (logoFile != null && !logoFile.isEmpty()) {
            company.setLogo(logoFile.getBytes());
        }
        return companyRepo.save(company);
    }

    public List<Company> getAllCompanies(){
        return companyRepo.findAll();

    }

    @Override
    public Company updateCompany(Long companyId, Map<String, Object> fieldsToUpdate) {
        Optional<Company> companyOptional = companyRepo.findById(companyId);
        if (companyOptional.isPresent()) {
            Company existingCompany = companyOptional.get();
            updateFields(existingCompany, fieldsToUpdate);
            return companyRepo.save(existingCompany);
        } else {
            throw new RuntimeException("Company not found with id: " + companyId);
        }
    }

    // Helper method to update fields dynamically
    private void updateFields(Company company, Map<String, Object> fieldsToUpdate) {
        try {
            for (Map.Entry<String, Object> entry : fieldsToUpdate.entrySet()) {
                Field field = Company.class.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(company, entry.getValue());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to update company fields", e);
        }
    }
}
