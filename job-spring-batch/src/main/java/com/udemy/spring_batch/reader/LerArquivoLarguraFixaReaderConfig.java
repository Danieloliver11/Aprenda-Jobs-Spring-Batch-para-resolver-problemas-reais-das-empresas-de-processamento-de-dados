package com.udemy.spring_batch.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.udemy.spring_batch.modele.dto.ClienteDto;

//@Configuration
public class LerArquivoLarguraFixaReaderConfig {
	
	
	
//	@Bean
//	@StepScope
//	public FlatFileItemReader<ClienteDto> lerArquivoLarguraFixaReader
//	(@Value("#{jobParameters['arquivoClientes']}") Resource arquivoCliente
//			) {
//	  
//		if (arquivoCliente == null || !arquivoCliente.exists()) {
//	        throw new IllegalArgumentException("O parâmetro 'arquivoClientes' não foi fornecido ou o arquivo não existe.");
//	    }
//
//
//	    return new FlatFileItemReaderBuilder<ClienteDto>()
//	            .name("lerArquivoLarguraFixaReader")
//	            .resource(arquivoCliente)
//	            .fixedLength()
//	            .columns(new Range[]{new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43)})
//	            .names("nome", "sobreNome", "idade", "email")
//	            .targetType(ClienteDto.class)
//	            .build();
//	}
//	
}


//@Bean
//ItemReader<Integer> contarAteDezReader() {
//    List<Integer> numeroDeUmAteDez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//    return new ListItemReader<>(numeroDeUmAteDez); 
//}