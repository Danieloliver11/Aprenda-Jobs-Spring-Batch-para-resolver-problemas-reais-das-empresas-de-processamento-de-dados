package com.udemy.spring_batch.jdbccursor.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.spring_batch.modele.dto.ClienteDto;
import com.udemy.spring_batch.modele.rowMapper.ClienteRowMapper;

@Configuration
public class JdbcPaginItemReaderConfig {
	
	@Bean
	public JdbcPagingItemReader<ClienteDto> jdbcPaginItemReader(@Qualifier(value = "projetoDataSource") DataSource dataSource, PagingQueryProvider queryProvider){
		
		return new JdbcPagingItemReaderBuilder<ClienteDto>()
				.name("jdbcPaginItemReader")
				.dataSource(dataSource)
				.queryProvider(queryProvider )
				.pageSize(1)
	            .rowMapper(new ClienteRowMapper()) //  RowMapper personalizado
				.build();
	}
	
	@Bean
	public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier(value = "projetoDataSource") DataSource dataSource) {
		
		SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
		queryProvider.setDataSource(dataSource);
		queryProvider.setSelectClause("select *");
		queryProvider.setFromClause("from cliente");
		queryProvider.setSortKey("email");
		
		return queryProvider;
	}

}
