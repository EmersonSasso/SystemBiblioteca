/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuário
 */
@Entity
@Table(name = "t_genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TGenero.findAll", query = "SELECT t FROM TGenero t")
    , @NamedQuery(name = "TGenero.findByGeneroId", query = "SELECT t FROM TGenero t WHERE t.generoId = :generoId")
    , @NamedQuery(name = "TGenero.findByNome", query = "SELECT t FROM TGenero t WHERE t.nome = :nome")
    , @NamedQuery(name = "TGenero.findByAtivo", query = "SELECT t FROM TGenero t WHERE t.ativo = :ativo")
    , @NamedQuery(name = "TGenero.findByCreationDate", query = "SELECT t FROM TGenero t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TGenero.findByLastUpdatedTime", query = "SELECT t FROM TGenero t WHERE t.lastUpdatedTime = :lastUpdatedTime")})
public class TGenero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "genero_id")
    private Long generoId;
    @Column(name = "nome")
    private String nome;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "last_updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedTime;
    @JoinColumn(name = "created_by", referencedColumnName = "usuario_id")
    @ManyToOne
    private TUsuario createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "usuario_id")
    @ManyToOne
    private TUsuario lastUpdatedBy;
    @OneToMany(mappedBy = "generoId")
    private Collection<TLivro> tLivroCollection;

    public TGenero() {
    }

    public TGenero(Long generoId) {
        this.generoId = generoId;
    }

    public Long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
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

    @XmlTransient
    public Collection<TLivro> getTLivroCollection() {
        return tLivroCollection;
    }

    public void setTLivroCollection(Collection<TLivro> tLivroCollection) {
        this.tLivroCollection = tLivroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generoId != null ? generoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TGenero)) {
            return false;
        }
        TGenero other = (TGenero) object;
        if ((this.generoId == null && other.generoId != null) || (this.generoId != null && !this.generoId.equals(other.generoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.TGenero[ generoId=" + generoId + " ]";
    }
    
}
