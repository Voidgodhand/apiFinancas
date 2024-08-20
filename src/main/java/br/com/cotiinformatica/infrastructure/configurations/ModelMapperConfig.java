package br.com.cotiinformatica.infrastructure.configurations;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ModelMapperConfig {
	@Bean
	ModelMapper getModelMapper() {
		
		var modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		return modelMapper;
	}
}