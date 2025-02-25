package com.udemy.spring_batch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.spring_batch.modele.dto.ClienteDto;
import com.udemy.spring_batch.modele.dto.TransacaoDto;

@Configuration
public class LerArquivoLarguraFixaWriterConfig {

//    @Bean
//    ItemWriter<ClienteDto> meuItemWriter() {
//        return items -> items.forEach(System.out::println);
//    }
	
	
	@Bean
	public ItemWriter<Object> writer() {
	    return items -> items.forEach(item -> {
	        if (item instanceof ClienteDto cliente) {
	            System.out.println("Cliente: " + cliente);
	        } else if (item instanceof TransacaoDto transacao) {
	            System.out.println("Transação: " + transacao);
	        } else {
	            throw new IllegalArgumentException("Tipo desconhecido: " + item.getClass());
	        }
	    });
	    
	}
}
