package com.migramcas.layaed.architecture.finsalud.repository.converters;

import com.migramcas.layaed.architecture.finsalud.entity.core.enums.GoalPriority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GoalPriorityConverter implements AttributeConverter<GoalPriority, String> {

    @Override
    public String convertToDatabaseColumn(GoalPriority attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getId() + ":" + attribute.getDescription();
    }

    @Override
    public GoalPriority convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        String[] parts = dbData.split(":");
        Integer id = Integer.valueOf(parts[0]);
        return GoalPriority.of(id);
    }
}
