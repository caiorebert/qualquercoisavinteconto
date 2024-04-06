package com.imd.qualquercoisa20conto.repository;

import com.imd.qualquercoisa20conto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "select u from Usuario u where u.email like %:email%")
    Usuario getUsuarioByEmail(String email);

    @Query(value = "select u from Usuario u where u.id = :id")
    Usuario getUsuarioById(Long id);

    @Query(value = "UPDATE Usuario u SET u.deletedAt = :timestamp where u.id = :id")
    void safeDeleteById(Long id, LocalDateTime timestamp);
}
