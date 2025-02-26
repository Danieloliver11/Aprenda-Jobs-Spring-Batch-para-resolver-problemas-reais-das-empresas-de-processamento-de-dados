package com.udemy.spring_batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiplosFormatosJobConfig {
	
	@Bean
	Job arquivoMultiplosFormatosJob(JobRepository jobRepository, Step arquivoMultiplosFormatosStep) {
		return new JobBuilder("arquivoMultiplosFormatosJob",jobRepository)
				.start(arquivoMultiplosFormatosStep)
				.incrementer(new RunIdIncrementer())
				.build();
		
	}

}
