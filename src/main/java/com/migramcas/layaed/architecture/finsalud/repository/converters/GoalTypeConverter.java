package com.migramcas.layaed.architecture.finsalud.repository.converters;

import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GoalTypeConverter implements AttributeConverter<GoalType, String> {

    @Override
    public String convertToDatabaseColumn(GoalType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getId() + ":" + attribute.getDescription();
    }

    @Override
    public GoalType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        String[] parts = dbData.split(":");
        Integer id = Integer.valueOf(parts[0]);
        return GoalType.of(id);
    }
}
