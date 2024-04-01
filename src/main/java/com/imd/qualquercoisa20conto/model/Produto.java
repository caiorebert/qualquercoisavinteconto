package com.imd.qualquercoisa20conto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
