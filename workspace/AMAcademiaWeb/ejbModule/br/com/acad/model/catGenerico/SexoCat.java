package br.com.acad.model.catGenerico;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SexoCat implements Serializable{
	
	private int id;
	
	private String nome;
	
	public SexoCat(){}

	public SexoCat(int id, String nome) {
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