package br.com.acad.dao.treino.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.treino.DiaTreino;

@Remote
public interface DiaTreinoDAO extends DAO<DiaTreino,Integer>{
	
	
	
}