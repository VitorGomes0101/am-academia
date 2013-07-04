package br.com.acad.dao.contato.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.contato.interf.TelefoneDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Telefone;

@Stateless
public class TelefoneDAOImpl extends DAOImpl<Telefone,Integer> implements TelefoneDAO{

	public TelefoneDAOImpl() {
		super();
	}

}