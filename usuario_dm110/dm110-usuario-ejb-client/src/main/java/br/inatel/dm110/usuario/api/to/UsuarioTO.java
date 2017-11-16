package br.inatel.dm110.usuario.api.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable {

	private static final long serialVersionUID = 5404403666512844085L;
	private Long id;
	private String nome;
	private String email;
	private String telefone;

	public UsuarioTO() {
		super();
	}

	public UsuarioTO(Long id, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
