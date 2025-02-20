package com.udemy.spring_batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.udemy.spring_batch.tasklet.MinhasTaklet;

//@Configuration
public class primeiroJobComStep {

//	@Bean
	public Step imprimeOlaStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager,
			MinhasTaklet imprimeOlaTasklet) {
		
		return new StepBuilder("imprimeOlaStep", jobRepository).tasklet(imprimeOlaTasklet, platformTransactionManager)
				.build();
	}
	
		
//	@Bean
//	Step imprimirParImparStep(JobRepository jobRepositry, PlatformTransactionManager platformTransactionManager) {
//		
//		return new StepBuilder("imprimirParImparStep",jobRepositry)
//				.<Integer, String>chunk(10, platformTransactionManager) // Integer = tipo do item lido, String = tipo do item processado/escrito. O 1 é o tamanho do chunk.				
//				.reader(contarAteDezReader())
//				.processor(parOuImparProcessor())
//				.writer(imprimeWriter())
//				.build();
//				
//	}
//	

}
