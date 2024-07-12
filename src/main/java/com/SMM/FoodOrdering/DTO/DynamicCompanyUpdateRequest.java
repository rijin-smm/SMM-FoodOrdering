package com.SMM.FoodOrdering.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DynamicCompanyUpdateRequest {
    private Map<String, Object> fieldsToUpdate;

    public Map<String, Object> getFieldsToUpdate() {
        return fieldsToUpdate;
    }
}
