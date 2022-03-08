/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "vw_livro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwLivro.findAll", query = "SELECT v FROM VwLivro v")
    , @NamedQuery(name = "VwLivro.findByLivroId", query = "SELECT v FROM VwLivro v WHERE v.livroId = :livroId")
    , @NamedQuery(name = "VwLivro.findByIsbn", query = "SELECT v FROM VwLivro v WHERE v.isbn = :isbn")
    , @NamedQuery(name = "VwLivro.findByLivro", query = "SELECT v FROM VwLivro v WHERE v.livro = :livro")
    , @NamedQuery(name = "VwLivro.findByEditora", query = "SELECT v FROM VwLivro v WHERE v.editora = :editora")
    , @NamedQuery(name = "VwLivro.findByAutor", query = "SELECT v FROM VwLivro v WHERE v.autor = :autor")
    , @NamedQuery(name = "VwLivro.findByGenero", query = "SELECT v FROM VwLivro v WHERE v.genero = :genero")
    , @NamedQuery(name = "VwLivro.findByAtivo", query = "SELECT v FROM VwLivro v WHERE v.ativo = :ativo")
    , @NamedQuery(name = "VwLivro.findByPublicado", query = "SELECT v FROM VwLivro v WHERE v.publicado = :publicado")})
public class VwLivro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "livro_id")
    @Id
    private BigInteger livroId;
    @Column(name = "isbn")
    private BigInteger isbn;
    @Column(name = "livro")
    private String livro;
    @Column(name = "editora")
    private String editora;
    @Column(name = "autor")
    private String autor;
    @Column(name = "genero")
    private String genero;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "publicado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publicado;

    public VwLivro() {
    }

    public BigInteger getLivroId() {
        return livroId;
    }

    public void setLivroId(BigInteger livroId) {
        this.livroId = livroId;
    }

    public BigInteger getIsbn() {
        return isbn;
    }

    public void setIsbn(BigInteger isbn) {
        this.isbn = isbn;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
    
}
