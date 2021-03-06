package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.dieta.interf.DietaEspecificaDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.DietaLogic;
import br.com.acad.model.dieta.Dieta;
import br.com.acad.model.dieta.DietaEspecifica;
import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Component
@Scope(value = "view")
public class DietaEspecificaBean extends Bean<DietaEspecifica> implements Serializable
{

    /************************************************************************************************************/
    // ATRIBUTOS
    /************************************************************************************************************/

    @Autowired
    private DietaEspecificaDAO dietaEspecificaDAO;
    @Autowired
    private ProfessorFuncDAO professorFuncDAO;

    public String textoDieta;

    /************************************************************************************************************/
    // METODOS
    /************************************************************************************************************/

    @PostConstruct
    @Override
    public void beforeInit()
    {
        dao = dietaEspecificaDAO;
        superClasses = new Class<?>[] { Dieta.class };
    }

    /**
     * show form de entity Não é possivel incluir um dieta especifico. Precisa ser por meio de resposta a uma
     * solicitação. Metodo nao implementado
     */
    @Override
    public void beforeShowNewEntity()
    {
    }

    @Override
    public void beforeShowFormDetail()
    {
        textoDieta = DietaLogic.getDietaString(entity);
    }

    /************************************************************************************************************/
    // GET FIELDS
    /************************************************************************************************************/

    /**
     * busca todos ProfessorFunc para preencher o field
     */
    public List<ProfessorFunc> getProfessorFuncField()
    {
        return professorFuncDAO.buscarFieldNomeProf();
    }

    /************************************************************************************************************/
    // GETS E SETS
    /************************************************************************************************************/

    public String getTextoDieta()
    {
        return textoDieta;
    }

}
