package br.com.acad.dao.treino.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.TreinoFixoDAO;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.treino.TreinoFixo;

@Stateless
public class TreinoFixoDAOImpl extends DAOImpl<TreinoFixo,Integer> implements TreinoFixoDAO{

	public TreinoFixoDAOImpl() {
		super();
	}

	@Override
	public List<TreinoFixo> buscarTodos() {
		TypedQuery<TreinoFixo> q = em.createQuery("from TreinoFixo", TreinoFixo.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(TreinoFixo.STATIC_FIELDS, "TreinoFixo", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<TreinoFixo> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<TreinoFixo> q = em.createQuery(SqlLogic.getSql(TreinoFixo.STATIC_FIELDS, "TreinoFixo", txtSearch, order), TreinoFixo.class);
				
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<TreinoFixo> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<TreinoFixo> q = em.createQuery(SqlLogic.getFilterSql(filtros, "TreinoFixo", order), TreinoFixo.class);
		
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
		Query q = em.createQuery(SqlLogic.getCountFilterSql("TreinoFixo", filtros));
		return  (Long) q.getSingleResult();
	}


}
