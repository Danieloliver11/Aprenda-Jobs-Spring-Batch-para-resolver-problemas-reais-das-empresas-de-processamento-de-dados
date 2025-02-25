package com.udemy.spring_batch.modele.dto;


public  class ClienteDto {

    private String nome;
    private String sobreNome;
    private Integer idade;
    private String email;
    
    public ClienteDto() {
    }

    // Construtor com argumentos (opcional)
    public ClienteDto(String nome, String sobreNome, Integer idade, String email) {
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}