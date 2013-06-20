package br.com.acad.model.treino;

import java.io.Serializable;


@SuppressWarnings("serial")
public class ParteCorpo implements Serializable {

	private int id;
	
	private String nome;

	
	public ParteCorpo(){}
	
	public ParteCorpo(int id, String nome) {
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