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
@Table(name = "t_editor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEditor.findAll", query = "SELECT t FROM TEditor t")
    , @NamedQuery(name = "TEditor.findByEditorId", query = "SELECT t FROM TEditor t WHERE t.editorId = :editorId")
    , @NamedQuery(name = "TEditor.findByNome", query = "SELECT t FROM TEditor t WHERE t.nome = :nome")
    , @NamedQuery(name = "TEditor.findByCreationDate", query = "SELECT t FROM TEditor t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TEditor.findByLastUpdatedTime", query = "SELECT t FROM TEditor t WHERE t.lastUpdatedTime = :lastUpdatedTime")})
public class TEditor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "editor_id")
    private Long editorId;
    @Column(name = "nome")
    private String nome;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "last_updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedTime;
    @OneToMany(mappedBy = "editorId")
    private Collection<TLivro> tLivroCollection;
    @JoinColumn(name = "created_by", referencedColumnName = "usuario_id")
    @ManyToOne
    private TUsuario createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "usuario_id")
    @ManyToOne
    private TUsuario lastUpdatedBy;

    public TEditor() {
    }

    public TEditor(Long editorId) {
        this.editorId = editorId;
    }

    public Long getEditorId() {
        return editorId;
    }

    public void setEditorId(Long editorId) {
        this.editorId = editorId;
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

    @XmlTransient
    public Collection<TLivro> getTLivroCollection() {
        return tLivroCollection;
    }

    public void setTLivroCollection(Collection<TLivro> tLivroCollection) {
        this.tLivroCollection = tLivroCollection;
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
        hash += (editorId != null ? editorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEditor)) {
            return false;
        }
        TEditor other = (TEditor) object;
        if ((this.editorId == null && other.editorId != null) || (this.editorId != null && !this.editorId.equals(other.editorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.TEditor[ editorId=" + editorId + " ]";
    }
    
}
