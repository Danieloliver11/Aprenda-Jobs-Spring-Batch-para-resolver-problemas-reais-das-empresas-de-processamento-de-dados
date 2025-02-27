package com.udemy.spring_batch.jdbccursor.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.spring_batch.modele.dto.ClienteDto;
import com.udemy.spring_batch.modele.rowMapper.ClienteRowMapper;

@Configuration
public class JdbcCursorItemReaderConfig {
	
	@Bean
	public JdbcCursorItemReader<ClienteDto> jdbcCursorReader(@Qualifier(value = "projetoDataSource") DataSource dataSource){
		
		return new JdbcCursorItemReaderBuilder<ClienteDto>()
				.name("jdbcCursorReader")
				.dataSource(dataSource)
				.sql("select * from cliente")
	            .rowMapper(new ClienteRowMapper()) //  RowMapper personalizado
				.build();
	}

}
