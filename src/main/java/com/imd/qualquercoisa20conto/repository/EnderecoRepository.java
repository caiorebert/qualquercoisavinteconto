package com.imd.qualquercoisa20conto.repository;

import com.imd.qualquercoisa20conto.model.Endereco;
import com.imd.qualquercoisa20conto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query(value = "select e from Endereco e where e.usuario = :usuario")
    Endereco getEnderecoByIdUsuario(Usuario usuario);

    @Query(value = "UPDATE Usuario u SET u.deletedAt = :timestamp where u.id = :id")
    void safeDeleteById(Long id, LocalDateTime timestamp);
}
