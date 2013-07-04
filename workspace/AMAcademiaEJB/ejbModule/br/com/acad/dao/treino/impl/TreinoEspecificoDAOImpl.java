package br.com.acad.dao.treino.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.TreinoEspecificoDAO;
import br.com.acad.model.treino.TreinoEspecifico;

@Stateless
public class TreinoEspecificoDAOImpl extends DAOImpl<TreinoEspecifico,Integer> implements TreinoEspecificoDAO{

	public TreinoEspecificoDAOImpl() {
		super();
	}

}