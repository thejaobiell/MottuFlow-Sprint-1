package com.sprint.MottuFlow.dto;

public class ArucoTagDTO {

    private Long idTag;
    private String codigo;
    private Long idMoto;
    private String status;

    public ArucoTagDTO() {}

    public ArucoTagDTO(Long idTag, String codigo, Long idMoto, String status) {
        this.idTag = idTag;
        this.codigo = codigo;
        this.idMoto = idMoto;
        this.status = status;
    }

	public Long getIdTag() {
		return idTag;
	}

	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getIdMoto() {
		return idMoto;
	}

	public void setIdMoto(Long idMoto) {
		this.idMoto = idMoto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    // Getters e Setters
    // ...
}
