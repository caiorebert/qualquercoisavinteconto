package com.imd.qualquercoisa20conto.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "")
    private List<Produto> produtos;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
