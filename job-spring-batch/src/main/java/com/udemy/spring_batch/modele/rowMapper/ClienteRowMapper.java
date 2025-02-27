package com.udemy.spring_batch.modele.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.udemy.spring_batch.modele.dto.ClienteDto;

public class ClienteRowMapper implements RowMapper<ClienteDto> {

	@Override
	public ClienteDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		 ClienteDto cliente = new ClienteDto();
	        cliente.setNome(rs.getString("nome")); // Mapeia 'nome' para 'clienteNome'
	        cliente.setSobreNome(rs.getString("sobrenome"));
	        cliente.setIdade(rs.getString("idade"));
	        cliente.setEmail(rs.getString("email"));

	        
	        return cliente;
	}

}
