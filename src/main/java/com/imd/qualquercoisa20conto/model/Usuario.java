package com.imd.qualquercoisa20conto.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private String password;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<Endereco> endereco;

    @OneToOne(mappedBy = "usuario")
    private Vendedor vendedor;

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
}
