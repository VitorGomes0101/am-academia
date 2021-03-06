package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.acad.annotation.Show;
import br.com.acad.dao.treino.interf.DiaTreinoDAO;
import br.com.acad.logic.TreinoLogic;
import br.com.acad.logic.model.FieldType;
import br.com.acad.model.GenericEntity;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ACAD_TREINO")
public class Treino implements Serializable, GenericEntity
{

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TREINO")
    private int id;

    @Column(length = 255, nullable = false)
    @Show(label = "Nome", order = true, filter = true)
    protected String nome;

    @Column(length = 500, nullable = true)
    protected String descricao;

    @Column(nullable = true)
    protected long tempoDescanso;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @Show(label = "Data", order = true, Type = FieldType.DATE, filter = true)
    private Calendar data;

    @ManyToOne
    @JoinColumn(name = "PROFESSOR_ID", nullable = true)
    @Show(label = "Professor", mappedName = "professor.nome", order = true, linkMap = "/xhtml/pessoa/professorFunc.xhtml", filter = true)
    private ProfessorFunc professor;

    @Column(nullable = false)
    private TipoTreinoDieta tipoTreino;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TREINO_ID")
    private Set<DiaTreino> diasTreino = new HashSet<DiaTreino>();

    @Transient
    private String treinoStr;

    // Metodos
    public void generateTreinoStr(DiaTreinoDAO diaTreinoDAO)
    {
        List<DiaTreino> dias = diaTreinoDAO.buscaPorTreino(this);
        this.setDiasTreino(new HashSet<DiaTreino>(dias));
        this.setTreinoStr(TreinoLogic.getTreinoString(this));
    }

    public boolean addDiaTreino(DiaTreino dia)
    {
        return diasTreino.add(dia);
    }

    public boolean removeDiaTreino(DiaTreino dia)
    {
        return diasTreino.remove(dia);
    }

    /**
     * Apaga lista de DiaTreino
     */
    public void resetDiasTreino()
    {
        this.diasTreino = new HashSet<DiaTreino>();
    }

    // Gets com DAO
    public List<DiaTreino> getDiasTreinos(DiaTreinoDAO dao)
    {
        return dao.buscaPorTreino(this);
    }

    // Construtores
    public Treino()
    {
    }

    // Gets e Sets
    public long getTempoDescanso()
    {
        return tempoDescanso;
    }

    public String getTreinoStr()
    {
        return treinoStr;
    }

    public void setTempoDescanso(long tempoDescanso)
    {
        this.tempoDescanso = tempoDescanso;
    }

    public Set<DiaTreino> getDiasTreino()
    {
        return diasTreino;
    }

    public void setDiasTreino(Set<DiaTreino> diasTreino)
    {
        this.diasTreino = diasTreino;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public Calendar getData()
    {
        return data;
    }

    public void setData(Calendar data)
    {
        this.data = data;
    }

    public TipoTreinoDieta getTipoTreino()
    {
        return tipoTreino;
    }

    public void setTipoTreino(TipoTreinoDieta tipoTreino)
    {
        this.tipoTreino = tipoTreino;
    }

    public ProfessorFunc getProfessor()
    {
        return professor;
    }

    public void setProfessor(ProfessorFunc professor)
    {
        this.professor = professor;
    }

    public void setTreinoStr(String treinoStr)
    {
        this.treinoStr = treinoStr;
    }

}
