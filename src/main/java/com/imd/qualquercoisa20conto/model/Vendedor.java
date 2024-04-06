package com.imd.qualquercoisa20conto.model;

import jakarta.persistence.*;
import org.hibernate.mapping.Join;

import java.util.List;

@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 40)
    private String nome;

    @Column(length = 400)
    private String descricao;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "vendedor")
    private List<Produto> produtos;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
