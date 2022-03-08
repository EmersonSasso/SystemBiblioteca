/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuário
 */
@Entity
@Table(name = "t_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUsuario.findAll", query = "SELECT t FROM TUsuario t")
    , @NamedQuery(name = "TUsuario.findByUsuarioId", query = "SELECT t FROM TUsuario t WHERE t.usuarioId = :usuarioId")
    , @NamedQuery(name = "TUsuario.findByNome", query = "SELECT t FROM TUsuario t WHERE t.nome = :nome")})
public class TUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Long usuarioId;
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "createdBy")
    private Collection<TGenero> tGeneroCollection;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private Collection<TGenero> tGeneroCollection1;
    @OneToMany(mappedBy = "createdBy")
    private Collection<TAutor> tAutorCollection;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private Collection<TAutor> tAutorCollection1;
    @OneToMany(mappedBy = "createdBy")
    private Collection<TLivro> tLivroCollection;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private Collection<TLivro> tLivroCollection1;
    @OneToMany(mappedBy = "createdBy")
    private Collection<TEditor> tEditorCollection;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private Collection<TEditor> tEditorCollection1;

    public TUsuario() {
    }

    public TUsuario(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<TGenero> getTGeneroCollection() {
        return tGeneroCollection;
    }

    public void setTGeneroCollection(Collection<TGenero> tGeneroCollection) {
        this.tGeneroCollection = tGeneroCollection;
    }

    @XmlTransient
    public Collection<TGenero> getTGeneroCollection1() {
        return tGeneroCollection1;
    }

    public void setTGeneroCollection1(Collection<TGenero> tGeneroCollection1) {
        this.tGeneroCollection1 = tGeneroCollection1;
    }

    @XmlTransient
    public Collection<TAutor> getTAutorCollection() {
        return tAutorCollection;
    }

    public void setTAutorCollection(Collection<TAutor> tAutorCollection) {
        this.tAutorCollection = tAutorCollection;
    }

    @XmlTransient
    public Collection<TAutor> getTAutorCollection1() {
        return tAutorCollection1;
    }

    public void setTAutorCollection1(Collection<TAutor> tAutorCollection1) {
        this.tAutorCollection1 = tAutorCollection1;
    }

    @XmlTransient
    public Collection<TLivro> getTLivroCollection() {
        return tLivroCollection;
    }

    public void setTLivroCollection(Collection<TLivro> tLivroCollection) {
        this.tLivroCollection = tLivroCollection;
    }

    @XmlTransient
    public Collection<TLivro> getTLivroCollection1() {
        return tLivroCollection1;
    }

    public void setTLivroCollection1(Collection<TLivro> tLivroCollection1) {
        this.tLivroCollection1 = tLivroCollection1;
    }

    @XmlTransient
    public Collection<TEditor> getTEditorCollection() {
        return tEditorCollection;
    }

    public void setTEditorCollection(Collection<TEditor> tEditorCollection) {
        this.tEditorCollection = tEditorCollection;
    }

    @XmlTransient
    public Collection<TEditor> getTEditorCollection1() {
        return tEditorCollection1;
    }

    public void setTEditorCollection1(Collection<TEditor> tEditorCollection1) {
        this.tEditorCollection1 = tEditorCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUsuario)) {
            return false;
        }
        TUsuario other = (TUsuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.TUsuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
