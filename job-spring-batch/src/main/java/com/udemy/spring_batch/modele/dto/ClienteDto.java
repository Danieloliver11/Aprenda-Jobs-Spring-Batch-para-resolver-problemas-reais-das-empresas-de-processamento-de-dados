package com.udemy.spring_batch.modele.dto;

import java.util.ArrayList;
import java.util.List;

public  class ClienteDto {

    private String nome;
    private String sobreNome;
    private String idade;
    private String email;
    private List<TransacaoDto> transacoes = new ArrayList<>();
    
    public ClienteDto() {
    }

    // Construtor com argumentos (opcional)
    public ClienteDto(String nome, String sobreNome, String idade, String email) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
        this.email = email;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


	public List<TransacaoDto> getTransacoes() {
		return transacoes;
	}


	public void setTransacoes(List<TransacaoDto> transacoes) {
		this.transacoes = transacoes;
	}


	@Override
	public String toString() {
		return "ClienteDto [nome=" + nome + ", sobreNome=" + sobreNome + ", idade=" + idade + ", email=" + email
				+ ", transacoes=" + transacoes + "]";
	}
    
    

}