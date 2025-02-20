package com.udemy.spring_batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.udemy.spring_batch.step.modele.dto.ClienteDto;

@Configuration
public class LerArquivoLarguraFixaStepConfig {
	
	
	@Bean
	Step lerArquivoLarguraFixaStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager			
			, FlatFileItemReader<ClienteDto> lerArquivoLarguraFixaReader,
			ItemWriter<ClienteDto> meuItemWriter){

		return new StepBuilder("lerArquivoLarguraFixaStep",jobRepository)
				.<ClienteDto,ClienteDto>chunk(2,platformTransactionManager)
				.reader(lerArquivoLarguraFixaReader)
	            .writer(meuItemWriter)  
				.build();
		
	}
	
	

}
