package com.enigma.trashbank.configs;

import com.enigma.trashbank.entities.Unit;
import com.enigma.trashbank.models.unit.UnitModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy((MatchingStrategies.STRICT));

        modelMapper.typeMap(UnitModel.class, Unit.class).addMappings(mapper -> mapper.skip(Unit::setId));

        return modelMapper;
    }
}
