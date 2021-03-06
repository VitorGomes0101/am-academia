package br.com.acad.model.horario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.acad.annotation.Show;
import br.com.acad.logic.PathLogic;
import br.com.acad.logic.model.FieldType;
import br.com.acad.model.GenericEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_AULA")
public class Aula implements Serializable, GenericEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_AULA")
    private int id;

    @Column(length = 500, nullable = true)
    @Show(label = "Foto", pathName = "fotoLocalPath", Type = FieldType.SMALL_IMAGE)
    private String fotoLocal;

    @Column(length = 255, nullable = false)
    @Show(label = "Nome", filter = true)
    private String nome;

    @Column(length = 500, nullable = true)
    @Show(label = "Descrição", Type = FieldType.LARGE_TEXT)
    private String descricao;

    public Aula()
    {
        super();
    }

    public Aula(String nome, String descricao, String fotoLocal)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.fotoLocal = fotoLocal;
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

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getFotoLocal()
    {
        return fotoLocal;
    }

    public void setFotoLocal(String fotoLocal)
    {
        this.fotoLocal = fotoLocal;
    }

    public String getFotoLocalPath()
    {
        if (fotoLocal != null && fotoLocal.length() > 1)
        {
            return "/" + PathLogic.PATH_AULAS + fotoLocal;
        }
        return "/" + PathLogic.PATH_AULAS + "semFoto.jpg";
    }

}
