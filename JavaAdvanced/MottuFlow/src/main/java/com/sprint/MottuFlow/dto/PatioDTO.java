package com.sprint.MottuFlow.dto;

public class PatioDTO {

    private Long idPatio;
    private String nome;
    private String endereco;
    private int capacidadeMaxima;

    public PatioDTO() {}

    public PatioDTO(Long idPatio, String nome, String endereco, int capacidadeMaxima) {
        this.idPatio = idPatio;
        this.nome = nome;
        this.endereco = endereco;
        this.capacidadeMaxima = capacidadeMaxima;
    }

	public Long getIdPatio() {
		return idPatio;
	}

	public void setIdPatio(Long idPatio) {
		this.idPatio = idPatio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}
}
