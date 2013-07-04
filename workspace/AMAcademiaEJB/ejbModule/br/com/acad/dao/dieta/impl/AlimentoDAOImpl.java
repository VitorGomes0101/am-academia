package br.com.acad.dao.dieta.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.dieta.interf.AlimentoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.Alimento;

@Stateless
public class AlimentoDAOImpl extends DAOImpl<Alimento,Integer> implements AlimentoDAO{

	public AlimentoDAOImpl() {
		super();
	}

}