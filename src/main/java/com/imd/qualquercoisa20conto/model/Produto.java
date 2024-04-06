package com.imd.qualquercoisa20conto.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column
    private float preco;

    @Column
    private int quantidade;

    @Column(length = 400)
    private String image;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @Column
    private LocalDateTime deletedAt;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
