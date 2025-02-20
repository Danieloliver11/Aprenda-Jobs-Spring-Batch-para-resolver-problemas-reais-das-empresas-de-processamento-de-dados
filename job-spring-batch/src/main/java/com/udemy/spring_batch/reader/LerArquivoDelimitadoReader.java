package com.udemy.spring_batch.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.udemy.spring_batch.modele.dto.ClienteDto;

@Configuration
public class LerArquivoDelimitadoReader {
	

//passado por arguments arquivoClientes=file:files/lientelimitado.txt
	
    @Bean
    @StepScope
    public FlatFileItemReader<ClienteDto> lerArquivoLarguraFixaReader(@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes) {
        if (arquivoClientes == null || !arquivoClientes.exists()) {
            throw new IllegalArgumentException("O parâmetro 'arquivoClientesLimitados' não foi fornecido ou o arquivo não existe.");
        }

        return new FlatFileItemReaderBuilder<ClienteDto>()
                .name("lerArquivoDelimitadoReaders")
                .resource(arquivoClientes)
                .delimited()
                .names(new String[] {"nome", "sobreNome", "idade", "email"})
                .targetType(ClienteDto.class)
                .build();
    }

 

}
