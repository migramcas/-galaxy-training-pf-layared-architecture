package com.migramcas.layaed.architecture.finsalud.repository.converters;

import com.migramcas.layaed.architecture.finsalud.entity.core.enums.FinancialHealth;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FinancialHealthConverter implements AttributeConverter<FinancialHealth, String> {

    @Override
    public String convertToDatabaseColumn(FinancialHealth attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getId() + ":" + attribute.getDescription();
    }

    @Override
    public FinancialHealth convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        String[] parts = dbData.split(":");
        Integer id = Integer.valueOf(parts[0]);
        return FinancialHealth.of(id);
    }
}