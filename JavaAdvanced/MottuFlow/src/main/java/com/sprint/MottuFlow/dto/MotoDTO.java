package com.sprint.MottuFlow.dto;

public class MotoDTO {

    private Long idMoto;
    private String placa;
    private String modelo;
    private String fabricante;
    private int ano;
    private Long idPatio;
    private String localizacaoAtual;

    public MotoDTO() {}

    public MotoDTO(Long idMoto, String placa, String modelo, String fabricante, int ano, Long idPatio, String localizacaoAtual) {
        this.idMoto = idMoto;
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
        this.idPatio = idPatio;
        this.localizacaoAtual = localizacaoAtual;
    }

	public Long getIdMoto() {
		return idMoto;
	}

	public void setIdMoto(Long idMoto) {
		this.idMoto = idMoto;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Long getIdPatio() {
		return idPatio;
	}

	public void setIdPatio(Long idPatio) {
		this.idPatio = idPatio;
	}

	public String getLocalizacaoAtual() {
		return localizacaoAtual;
	}

	public void setLocalizacaoAtual(String localizacaoAtual) {
		this.localizacaoAtual = localizacaoAtual;
	}
}
