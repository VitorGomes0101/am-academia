package br.com.acad.dao.treino.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.DiasTreinoCatDAO;
import br.com.acad.model.treino.DiasTreinoCat;

@Stateless
public class DiasTreinoCatDAOImpl extends DAOImpl<DiasTreinoCat,Integer> implements DiasTreinoCatDAO{

	public DiasTreinoCatDAOImpl() {
		super();
	}

}
