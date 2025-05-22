package com.sprint.MottuFlow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FuncionarioDTO {

    private Long id;
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100)
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "CPF deve ter exatamente 11 caracteres")
    private String cpf;


    @NotBlank(message = "Cargo é obrigatório")
    @Size(max = 50)
    private String cargo;

    @NotBlank(message = "Telefone é obrigatório")
    @Size(max = 20)
    private String telefone;

    @NotBlank(message = "Usuário é obrigatório")
    @Size(max = 50)
    private String usuario;

    @NotBlank(message = "Senha é obrigatória")
    @Size(max = 100)
    private String senha;

    public FuncionarioDTO() {}

    public FuncionarioDTO(Long id, String nome, String cpf, String cargo, String telefone, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.telefone = telefone;
        this.usuario = usuario;
        this.senha = senha;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
