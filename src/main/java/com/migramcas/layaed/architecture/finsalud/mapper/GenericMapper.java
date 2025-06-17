package com.migramcas.layaed.architecture.finsalud.mapper;

import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import java.util.Collection;

public class GenericMapper {

    private final ModelMapper modelMapper;

    private Converter<GoalId, Integer> goalIdToInteger() {
        return new Converter<>() {
            @Override
            public Integer convert(MappingContext<GoalId, Integer> mappingContext) {
                return mappingContext.getSource().getValue();
            }
        };
    }

    public GenericMapper() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(goalIdToInteger());
    }

    public <T, D> D toMap(T instance, Class<D> clazz) {
        return modelMapper.map(instance, clazz);
    }

    public <T, D> Collection<D> toMap(Collection<T> instance, Class<D> clazz) {
        return instance.stream()
                .map(item -> modelMapper.map(instance, clazz))
                .toList();
    }

}
