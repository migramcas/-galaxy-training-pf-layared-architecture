package com.migramcas.layaed.architecture.finsalud.repository.converters;

import com.migramcas.layaed.architecture.finsalud.entity.core.application.Month;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MonthConverter implements AttributeConverter<Month, String> {

    @Override
    public String convertToDatabaseColumn(Month attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getId() + ":" + attribute.getDescription();
    }

    @Override
    public Month convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        String[] parts = dbData.split(":");
        Integer id = Integer.valueOf(parts[0]);
        return Month.of(id);
    }
}

