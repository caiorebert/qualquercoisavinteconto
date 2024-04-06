package com.imd.qualquercoisa20conto.repository;

import com.imd.qualquercoisa20conto.model.Compra;
import com.imd.qualquercoisa20conto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Integer> {

    @Query(value = "select e from Compra e where e.id = :id")
    Compra getCompraById(Long id);

    @Query(value = "select e from Compra e where e.usuario = :usuario")
    List<Compra> getComprasByIdUsuario(Usuario usuario);

    @Query(value = "UPDATE Usuario u SET u.deletedAt = :timestamp where u.id = :id")
    void safeDeleteById(Long id, LocalDateTime timestamp);
}
