package br.com.acad.dao.catGenerico.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.catGenerico.FaixaEtariaCat;

@Stateless
public class FaixaEtariaCatDAOImpl extends DAOImpl<FaixaEtariaCat,Integer> implements FaixaEtariaCatDAO{

	public FaixaEtariaCatDAOImpl() {
		super();
	}

}
