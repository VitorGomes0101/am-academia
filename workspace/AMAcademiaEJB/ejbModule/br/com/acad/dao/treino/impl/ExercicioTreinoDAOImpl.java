package br.com.acad.dao.treino.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.ExercicioTreinoDAO;
import br.com.acad.model.treino.ExercicioTreino;

@Stateless
public class ExercicioTreinoDAOImpl extends DAOImpl<ExercicioTreino,Integer> implements ExercicioTreinoDAO{

	public ExercicioTreinoDAOImpl() {
		super();
	}

}