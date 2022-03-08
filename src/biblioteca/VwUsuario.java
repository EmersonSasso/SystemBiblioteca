/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuário
 */
@Entity
@Table(name = "vw_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwUsuario.findAll", query = "SELECT v FROM VwUsuario v")
    , @NamedQuery(name = "VwUsuario.findByUsuarioId", query = "SELECT v FROM VwUsuario v WHERE v.usuarioId = :usuarioId")
    , @NamedQuery(name = "VwUsuario.findByNome", query = "SELECT v FROM VwUsuario v WHERE v.nome = :nome")
    , @NamedQuery(name = "VwUsuario.findByLogin", query = "SELECT v FROM VwUsuario v WHERE v.login = :login")
    , @NamedQuery(name = "VwUsuario.findBySenha", query = "SELECT v FROM VwUsuario v WHERE v.senha = :senha")
    , @NamedQuery(name = "VwUsuario.findByAtivo", query = "SELECT v FROM VwUsuario v WHERE v.ativo = :ativo")})
public class VwUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "usuario_id")
    private BigInteger usuarioId;
    @Column(name = "nome")
    private String nome;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "ativo")
    private Boolean ativo;

    public VwUsuario() {
    }

    public BigInteger getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(BigInteger usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
}
