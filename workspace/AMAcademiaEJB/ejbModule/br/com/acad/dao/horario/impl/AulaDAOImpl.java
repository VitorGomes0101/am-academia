package br.com.acad.dao.horario.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.AulaDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.horario.Aula;

@Stateless
public class AulaDAOImpl extends DAOImpl<Aula,Integer> implements AulaDAO{

	public AulaDAOImpl() {
		super();
	}

	@Override
	public List<Aula> buscarTodos() {
		TypedQuery<Aula> q = em.createQuery("from Aula", Aula.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(Aula.STATIC_FIELDS, "Aula", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<Aula> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<Aula> q = em.createQuery(SqlLogic.getSql(Aula.STATIC_FIELDS, "Aula", txtSearch, order), Aula.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}
	
	@Override
	public List<Aula> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<Aula> q = em.createQuery(SqlLogic.getFilterSql(filtros, "Aula", order), Aula.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		Query q = em.createQuery(SqlLogic.getCountFilterSql("Aula", filtros));
		return  (Long) q.getSingleResult();
	}

}
