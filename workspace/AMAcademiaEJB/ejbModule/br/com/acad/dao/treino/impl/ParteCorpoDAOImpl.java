package br.com.acad.dao.treino.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.treino.ParteCorpo;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;

@Stateless
public class ParteCorpoDAOImpl extends DAOImpl<ParteCorpo,Integer> implements ParteCorpoDAO{

	public ParteCorpoDAOImpl() {
		super();
	}

}