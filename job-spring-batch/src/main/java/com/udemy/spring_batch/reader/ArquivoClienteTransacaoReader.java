package com.udemy.spring_batch.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.udemy.spring_batch.modele.dto.ClienteDto;
import com.udemy.spring_batch.modele.dto.TransacaoDto;

public class ArquivoClienteTransacaoReader  implements ItemStreamReader<ClienteDto>{
	
	
	private Object objetoAtual;
	private ItemStreamReader<Object> delegate;
	
	
	public ArquivoClienteTransacaoReader(ItemStreamReader<Object> delegate){
		this.delegate = delegate;
	}
	
	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
	    delegate.open(executionContext);
	}
	
	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		ItemStreamReader.super.update(executionContext);
	}
	
	@Override
	public void close() throws ItemStreamException {
	    delegate.close();
	}

	
	
	@Override
	public ClienteDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		if(objetoAtual == null) {
			objetoAtual = delegate.read();
		}
			
		ClienteDto	clienteDto	= (ClienteDto) objetoAtual;
		
		objetoAtual = null;
		
		if(clienteDto != null) {
			while (peek() instanceof TransacaoDto)
				clienteDto.getTransacoes().add((TransacaoDto) objetoAtual);
		}
			
		
		return clienteDto;
	}

	private Object peek() throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {

		objetoAtual = delegate.read();
		
		return objetoAtual;
		
	}

}
