package br.inatel.dm110.usuario.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlTransient;

import br.inatel.dm110.usuario.api.to.UsuarioTO;

@Entity
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
public class Usuario {

	@Id
	@GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	private String email;
	private String telefone;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Usuario(UsuarioTO u) {
		this.id = u.getId();
		this.nome = u.getNome();
		this.email = u.getEmail();
		this.telefone = u.getTelefone();
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

	@XmlTransient
	public UsuarioTO toUsuarioTO() {
		UsuarioTO u = new UsuarioTO();
		u.setEmail(this.email);
		u.setId(this.id);
		u.setNome(this.nome);
		u.setTelefone(this.telefone);

		return u;
	}

}
