package com.udemy.spring_batch.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LerArquivoDelimitadoReaderConfig {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	@StepScope
	FlatFileItemReader lerArquivoDelimitadoReaders(@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes, LineMapper lineMapper) {
        if (arquivoClientes == null || !arquivoClientes.exists()) {
            throw new IllegalArgumentException("O parâmetro 'arquivoClientesLimitados' não foi fornecido ou o arquivo não existe.");
        }
        
		return new FlatFileItemReaderBuilder()
				.name("lerArquivoDelimitadoReaders")
                .resource(arquivoClientes)
                .lineMapper(lineMapper)
                .build();
	}

}
