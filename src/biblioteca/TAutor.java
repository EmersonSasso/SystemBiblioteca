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
@Table(name = "t_autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TAutor.findAll", query = "SELECT t FROM TAutor t")
    , @NamedQuery(name = "TAutor.findByAutorId", query = "SELECT t FROM TAutor t WHERE t.autorId = :autorId")
    , @NamedQuery(name = "TAutor.findByNome", query = "SELECT t FROM TAutor t WHERE t.nome = :nome")
    , @NamedQuery(name = "TAutor.findByCreationDate", query = "SELECT t FROM TAutor t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TAutor.findByLastUpdatedTime", query = "SELECT t FROM TAutor t WHERE t.lastUpdatedTime = :lastUpdatedTime")})
public class TAutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "autor_id")
    private Long autorId;
    @Column(name = "nome")
    private String nome;
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
    @OneToMany(mappedBy = "autorId")
    private Collection<TLivro> tLivroCollection;

    public TAutor() {
    }

    public TAutor(Long autorId) {
        this.autorId = autorId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        hash += (autorId != null ? autorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAutor)) {
            return false;
        }
        TAutor other = (TAutor) object;
        if ((this.autorId == null && other.autorId != null) || (this.autorId != null && !this.autorId.equals(other.autorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.TAutor[ autorId=" + autorId + " ]";
    }
    
}
