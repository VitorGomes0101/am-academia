package br.com.acad.dao.treino.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.SolicitacaoTreinoDAO;
import br.com.acad.model.treino.SolicitacaoTreino;

@Stateless
public class SolicitacaoTreinoDAOImpl extends DAOImpl<SolicitacaoTreino,Integer> implements SolicitacaoTreinoDAO{

	public SolicitacaoTreinoDAOImpl() {
		super();
	}

}
