package com.udemy.spring_batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LerArquivoLarguraFixaJobConfig {
	
	@Bean
	Job lerArquivoLarguraFixaJob(JobRepository jobRepository, Step lerArquivoLarguraFixaStep ){
		
		return new JobBuilder("lerArquivoLarguraFixaJob",jobRepository)
				.start(lerArquivoLarguraFixaStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}

}
