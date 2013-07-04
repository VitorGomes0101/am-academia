package br.com.acad.model.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_PESSOA_PROFESSOR_FUNC")
@PrimaryKeyJoinColumn(name="ID_PESSOA_PROFESSOR_FUNC")
public class ProfessorFunc extends Pessoa{

	@Column(length=500, nullable=true)
	private String fotoLocal;
	
	@Column(length=500, nullable=true)
	private String formacao;
	
	@Column(nullable=false)
	private boolean isProfessor;
	
	public boolean isProfessor() {
		return isProfessor;
	}
	public void setProfessor(boolean isProfessor) {
		this.isProfessor = isProfessor;
	}
	public String getFotoLocal() {
		return fotoLocal;
	}
	public void setFotoLocal(String fotoLocal) {
		this.fotoLocal = fotoLocal;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
}