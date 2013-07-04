package br.com.acad.dao.pessoa.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.model.pessoa.Aluno;

@Stateless
public class AlunoDAOImpl extends DAOImpl<Aluno,Integer> implements AlunoDAO{

	public AlunoDAOImpl() {
		super();
	}

}