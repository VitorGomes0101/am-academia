package br.com.acad.model.pessoa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.model.treino.Treino;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_PESSOA_ALUNO")
@PrimaryKeyJoinColumn(name="ID_PESSOA_ID")
public class Aluno extends Pessoa{

	@Column(nullable=true, precision=2)
	private double peso;
	
	@Column(nullable=true, precision=2)
	private double altura;
	
	@ManyToMany
	@JoinTable(name="ACAD_ALUNO_TREINO", 
				joinColumns={@JoinColumn(name="ALUNO_ID")},
				inverseJoinColumns={@JoinColumn(name="TREINO_ID")})
	private List<Treino> treinos;
	
	@ManyToMany
	@JoinTable(name="ACAD_ALUNO_DIETA", 
				joinColumns={@JoinColumn(name="ALUNO_DIETA")},
				inverseJoinColumns={@JoinColumn(name="DIETA_ID")})
	private List<Treino> dietas;
	
	
	public Aluno(){}
	
	public List<Treino> getDietas() {
		return dietas;
	}

	public void setDietas(List<Treino> dietas) {
		this.dietas = dietas;
	}

	public List<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}

	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
}