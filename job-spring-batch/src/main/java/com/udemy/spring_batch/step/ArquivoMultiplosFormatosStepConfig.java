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
import com.udemy.spring_batch.reader.ArquivoClienteTransacaoReader;

@Configuration
public class ArquivoMultiplosFormatosStepConfig {
	
	@Bean
	Step lerArquivoDelimitadoTransacaoStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager,
		 FlatFileItemReader lerArquivoDelimitadoReaders,
		 ItemWriter<Object> writer){
	
	
		return new StepBuilder("lerArquivoDelimitadoTransacaoStep",jobRepository )
			.<ClienteDto,ClienteDto>chunk(4,platformTransactionManager)
			.reader(new ArquivoClienteTransacaoReader(lerArquivoDelimitadoReaders))
			.writer(writer)
			.build();
}

}
