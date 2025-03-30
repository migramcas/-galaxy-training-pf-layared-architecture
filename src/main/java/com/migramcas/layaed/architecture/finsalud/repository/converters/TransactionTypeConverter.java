package com.migramcas.layaed.architecture.finsalud.repository.converters;

import com.migramcas.layaed.architecture.finsalud.entity.core.enums.TransactionType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TransactionTypeConverter implements AttributeConverter<TransactionType, String> {

    @Override
    public String convertToDatabaseColumn(TransactionType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getId() + ":" + attribute.getDescription();
    }

    @Override
    public TransactionType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        String[] parts = dbData.split(":");
        Integer id = Integer.valueOf(parts[0]);
        return TransactionType.of(id);
    }
}
