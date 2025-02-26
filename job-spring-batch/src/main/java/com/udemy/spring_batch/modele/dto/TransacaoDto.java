package com.udemy.spring_batch.modele.dto;

public class TransacaoDto {

	private String id;
	private String descricao;
	private Double valor;

	public TransacaoDto() {

	}

	public TransacaoDto(String id, String descricao, Double valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "TransacaoDto [id=" + id + ", descricao=" + descricao + ", valor=" + valor + "]";
	}

}
