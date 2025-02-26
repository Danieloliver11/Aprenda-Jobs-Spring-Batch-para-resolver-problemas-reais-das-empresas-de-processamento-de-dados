package com.udemy.spring_batch.LineMapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.spring_batch.modele.dto.ClienteDto;
import com.udemy.spring_batch.modele.dto.TransacaoDto;

@Configuration
public class ClienteTransacaoLineMapperConfig {

	@Bean
	PatternMatchingCompositeLineMapper clienteTransacaoLineMapper() {

		PatternMatchingCompositeLineMapper linerMapper = new PatternMatchingCompositeLineMapper();
		linerMapper.setFieldSetMappers(fieldSetMapper());
		linerMapper.setTokenizers(tokenizer());
		return linerMapper;

	}

	private Map<String, LineTokenizer> tokenizer() {
	    Map<String, LineTokenizer> tokenizers = new HashMap<>();
	    tokenizers.put("0*", clienteTokenizer());
	    tokenizers.put("1*", transacaoTokenizer());
	    return tokenizers;
	}

	private Map<String, FieldSetMapper<?>> fieldSetMapper() {
	    Map<String, FieldSetMapper<?>> fieldSetMappers = new HashMap<>();
	    fieldSetMappers.put("0*", fieldSetMapper(ClienteDto.class));
	    fieldSetMappers.put("1*", fieldSetMapper(TransacaoDto.class));
	    return fieldSetMappers;
	}
	private <T> FieldSetMapper<T> fieldSetMapper(Class<T> classe) {
	    BeanWrapperFieldSetMapper<T> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	    fieldSetMapper.setTargetType(classe);
	    return fieldSetMapper;
	}

	private LineTokenizer clienteTokenizer() {

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		lineTokenizer.setNames("nome", "sobreNome", "idade", "email");
		lineTokenizer.setIncludedFields(1, 2, 3, 4);

		return lineTokenizer;
	}

	private LineTokenizer transacaoTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		lineTokenizer.setNames("id", "descricao", "valor");
		lineTokenizer.setIncludedFields(1, 2, 3);

		return lineTokenizer;
	}

}
