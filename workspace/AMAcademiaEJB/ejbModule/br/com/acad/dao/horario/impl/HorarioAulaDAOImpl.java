package br.com.acad.dao.horario.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.HorarioAulaDAO;
import br.com.acad.model.horario.HorarioAula;

@Stateless
public class HorarioAulaDAOImpl extends DAOImpl<HorarioAula,Integer> implements HorarioAulaDAO{

	public HorarioAulaDAOImpl() {
		super();
	}

}