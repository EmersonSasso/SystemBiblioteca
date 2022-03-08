/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuário
 */
@Entity
@Table(name = "t_livro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLivro.findAll", query = "SELECT t FROM TLivro t")
    , @NamedQuery(name = "TLivro.findByLivroId", query = "SELECT t FROM TLivro t WHERE t.livroId = :livroId")
    , @NamedQuery(name = "TLivro.findByIsbn", query = "SELECT t FROM TLivro t WHERE t.isbn = :isbn")
    , @NamedQuery(name = "TLivro.findByNome", query = "SELECT t FROM TLivro t WHERE t.nome = :nome")
    , @NamedQuery(name = "TLivro.findByAtivo", query = "SELECT t FROM TLivro t WHERE t.ativo = :ativo")
    , @NamedQuery(name = "TLivro.findByPublicado", query = "SELECT t FROM TLivro t WHERE t.publicado = :publicado")
    , @NamedQuery(name = "TLivro.findByCreationDate", query = "SELECT t FROM TLivro t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TLivro.findByLastUpdatedTime", query = "SELECT t FROM TLivro t WHERE t.lastUpdatedTime = :lastUpdatedTime")})
public class TLivro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "livro_id")
    private Long livroId;
    @Column(name = "isbn")
    private BigInteger isbn;
    @Column(name = "nome")
    private String nome;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "publicado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publicado;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "last_updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedTime;
    @JoinColumn(name = "autor_id", referencedColumnName = "autor_id")
    @ManyToOne
    private TAutor autorId;
    @JoinColumn(name = "editor_id", referencedColumnName = "editor_id")
    @ManyToOne
    private TEditor editorId;
    @JoinColumn(name = "genero_id", referencedColumnName = "genero_id")
    @ManyToOne
    private TGenero generoId;
    @JoinColumn(name = "created_by", referencedColumnName = "usuario_id")
    @ManyToOne
    private TUsuario createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "usuario_id")
    @ManyToOne
    private TUsuario lastUpdatedBy;

    public TLivro() {
    }

    public TLivro(Long livroId) {
        this.livroId = livroId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public BigInteger getIsbn() {
        return isbn;
    }

    public void setIsbn(BigInteger isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getPublicado() {
        return publicado;
    }

    public void setPublicado(Date publicado) {
        this.publicado = publicado;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public TAutor getAutorId() {
        return autorId;
    }

    public void setAutorId(TAutor autorId) {
        this.autorId = autorId;
    }

    public TEditor getEditorId() {
        return editorId;
    }

    public void setEditorId(TEditor editorId) {
        this.editorId = editorId;
    }

    public TGenero getGeneroId() {
        return generoId;
    }

    public void setGeneroId(TGenero generoId) {
        this.generoId = generoId;
    }

    public TUsuario getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(TUsuario createdBy) {
        this.createdBy = createdBy;
    }

    public TUsuario getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(TUsuario lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (livroId != null ? livroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLivro)) {
            return false;
        }
        TLivro other = (TLivro) object;
        if ((this.livroId == null && other.livroId != null) || (this.livroId != null && !this.livroId.equals(other.livroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.TLivro[ livroId=" + livroId + " ]";
    }
    
}
