package br.com.acad.entity.treino;

import java.io.Serializable;

public class ObjetivoCat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	public ObjetivoCat(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
