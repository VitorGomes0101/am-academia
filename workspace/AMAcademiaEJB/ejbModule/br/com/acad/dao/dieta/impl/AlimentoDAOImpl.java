package br.com.acad.dao.dieta.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.AlimentoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.dieta.Alimento;

@Stateless
public class AlimentoDAOImpl extends DAOImpl<Alimento,Integer> implements AlimentoDAO{

	public AlimentoDAOImpl() {
		super();
	}

	@Override
	public List<Alimento> buscarTodos() {
		TypedQuery<Alimento> q = em.createQuery("from Alimento", Alimento.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(Alimento.STATIC_FIELDS, "Alimento", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<Alimento> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<Alimento> q = em.createQuery(SqlLogic.getSql(Alimento.STATIC_FIELDS, "Alimento", txtSearch, order), Alimento.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<Alimento> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<Alimento> q = em.createQuery(SqlLogic.getFilterSql(filtros, "Alimento", order), Alimento.class);
		
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
		Query q = em.createQuery(SqlLogic.getCountFilterSql("Alimento", filtros));
		return  (Long) q.getSingleResult();
	}

}
