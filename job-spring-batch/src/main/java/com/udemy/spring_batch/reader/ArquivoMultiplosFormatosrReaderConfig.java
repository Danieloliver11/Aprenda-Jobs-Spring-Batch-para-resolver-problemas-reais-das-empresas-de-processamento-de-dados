package com.udemy.spring_batch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

//@Configuration
public class ArquivoMultiplosFormatosrReaderConfig {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Bean
	FlatFileItemReader arquivoMultiplosFormatosrReader(@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes, LineMapper lineMapper) {
		
		 if (arquivoClientes == null || !arquivoClientes.exists()) {
	            throw new IllegalArgumentException("O parâmetro 'arquivoMultiplosFormatosrReader' não foi fornecido ou o arquivo não existe.");
	        }
	        return new FlatFileItemReaderBuilder()
	                .name("arquivoMultiplosFormatosrReader")
	                .resource(arquivoClientes)
	               .lineMapper(lineMapper)
	                .build();
	}

}
