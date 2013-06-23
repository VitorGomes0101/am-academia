package br.com.acad.dao.treino.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.model.treino.Exercicio;

@Stateless
public class DiaTreinoDAOImpl extends DAOImpl<Exercicio,Integer> implements ExercicioDAO{

	public DiaTreinoDAOImpl() {
		super();
	}

}
