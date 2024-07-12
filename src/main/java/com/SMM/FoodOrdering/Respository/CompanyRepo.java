package com.SMM.FoodOrdering.Respository;

import com.SMM.FoodOrdering.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {
}
