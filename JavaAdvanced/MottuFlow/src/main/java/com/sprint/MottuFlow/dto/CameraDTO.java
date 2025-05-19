package com.sprint.MottuFlow.dto;

public class CameraDTO {

    private Long idCamera;
    private String statusOperacional;
    private String localizacaoFisica;
    private Long idPatio;

    public CameraDTO() {}

    public CameraDTO(Long idCamera, String statusOperacional, String localizacaoFisica, Long idPatio) {
        this.idCamera = idCamera;
        this.statusOperacional = statusOperacional;
        this.localizacaoFisica = localizacaoFisica;
        this.idPatio = idPatio;
    }

	public Long getIdCamera() {
		return idCamera;
	}

	public void setIdCamera(Long idCamera) {
		this.idCamera = idCamera;
	}

	public String getStatusOperacional() {
		return statusOperacional;
	}

	public void setStatusOperacional(String statusOperacional) {
		this.statusOperacional = statusOperacional;
	}

	public String getLocalizacaoFisica() {
		return localizacaoFisica;
	}

	public void setLocalizacaoFisica(String localizacaoFisica) {
		this.localizacaoFisica = localizacaoFisica;
	}

	public Long getIdPatio() {
		return idPatio;
	}

	public void setIdPatio(Long idPatio) {
		this.idPatio = idPatio;
	}

    // Getters e Setters
    // ...
}
