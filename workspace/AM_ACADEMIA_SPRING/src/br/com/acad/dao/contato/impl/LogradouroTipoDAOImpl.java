package br.com.acad.dao.contato.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.contato.interf.LogradouroTipoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.LogradouroTipo;

@Repository
public class LogradouroTipoDAOImpl extends DAOImpl<LogradouroTipo, Integer> implements LogradouroTipoDAO
{

    public LogradouroTipoDAOImpl()
    {
        super();
    }

    @Override
    public List<LogradouroTipo> buscarTodos()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
