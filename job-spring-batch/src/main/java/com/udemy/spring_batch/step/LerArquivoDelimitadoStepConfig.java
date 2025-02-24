package com.udemy.spring_batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.udemy.spring_batch.modele.dto.ClienteDto;

@Configuration
public class LerArquivoDelimitadoStepConfig {
	
	@Bean
	Step lerArquivoDelimitadoStepConfigs(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager,
			 FlatFileItemReader<ClienteDto> lerArquivoDelimitadoReaders,
			 ItemWriter<ClienteDto> meuItemWriter){
		
		return new StepBuilder("platformTransactionManager",jobRepository )
				.<ClienteDto,ClienteDto>chunk(4,platformTransactionManager)
				.reader(lerArquivoDelimitadoReaders)
				.writer(meuItemWriter)
				.build();
	}

}
