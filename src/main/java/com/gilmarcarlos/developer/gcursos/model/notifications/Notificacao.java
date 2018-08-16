package com.gilmarcarlos.developer.gcursos.model.notifications;

import java.beans.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.gilmarcarlos.developer.gcursos.model.usuarios.Usuario;

@Entity
public class Notificacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String icone;
	private String status;
	private LocalDate dataNotificacao;
	private String mensagem;
	private Boolean foiLido;
	
	
	@OneToOne
	private Usuario usuario;
	
	public Notificacao() {
		
	}
	
	public Notificacao(Usuario usuario, String titulo, String icone, String status, String mensagem) {
		this.usuario = usuario;
		this.titulo = titulo;
		this.icone = icone;
		this.status = status;
		this.mensagem = mensagem;
		this.foiLido = false;
		this.dataNotificacao = LocalDate.now();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getFoiLido() {
		return foiLido;
	}

	public void setFoiLido(Boolean foiLido) {
		this.foiLido = foiLido;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDataNotificacao() {
		return dataNotificacao;
	}

	public void setDataNotificacao(LocalDate dataNotificacao) {
		this.dataNotificacao = dataNotificacao;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Transient
	public Integer getPeriodo() {
		return Period.between(LocalDate.now(), this.dataNotificacao).getDays();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacao other = (Notificacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
