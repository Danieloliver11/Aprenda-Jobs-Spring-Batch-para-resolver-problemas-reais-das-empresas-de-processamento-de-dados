package com.udemy.spring_batch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.spring_batch.modele.dto.ClienteDto;

@Configuration
public class LerArquivoLarguraFixaWriterConfig {

    @Bean
    ItemWriter<ClienteDto> meuItemWriter() {
        return items -> items.forEach(System.out::println);
    }
}
