package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acad.annotation.Show;
import br.com.acad.annotation.View;
import br.com.acad.logic.model.FieldType;
import br.com.acad.model.GenericEntity;
import br.com.acad.model.pessoa.Aluno;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_SOLICITACAO_TREINO")
@View(labels = { "Todos Registros", "Respondidas", "Não Respondidas" }, queries = { "", "respondido=true", "respondido=false" })
public class SolicitacaoTreino implements Serializable, GenericEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_SOLICITACAO_TREINO")
    private int id;

    @Column(length = 500, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_SOLICITACAO", nullable = false)
    @Show(label = "Data", order = true, Type = FieldType.DATE, filter = true)
    private Calendar dataSolicitacao;

    @ManyToOne
    @JoinColumn(name = "ALUNO_ID", nullable = false)
    @Show(label = "Aluno", mappedName = "aluno.nome", order = true, linkMap = "/xhtml/pessoa/aluno.xhtml", filter = true)
    private Aluno aluno;

    @Column(nullable = false)
    @Show(label = "Respondido", order = true, Type = FieldType.BOOLEAN, filter = true)
    private boolean respondido;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TREINO_ESPECIFICO_ID", nullable = true)
    private TreinoEspecifico treinoEspecifico;

    public SolicitacaoTreino()
    {
    }

    public SolicitacaoTreino(int id, String descricao, Calendar dataSolicitacao, boolean respondido)
    {
        super();
        this.id = id;
        this.descricao = descricao;
        this.dataSolicitacao = dataSolicitacao;
        this.respondido = respondido;
    }

    public SolicitacaoTreino(Integer id, Calendar dataSolicitacao)
    {
        this.id = id;
        this.dataSolicitacao = dataSolicitacao;
    }

    public boolean isRespondido()
    {
        return respondido;
    }

    public void setRespondido(boolean respondido)
    {
        this.respondido = respondido;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public Calendar getDataSolicitacao()
    {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Calendar dataSolicitacao)
    {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Aluno getAluno()
    {
        return aluno;
    }

    public void setAluno(Aluno aluno)
    {
        this.aluno = aluno;
    }

}
