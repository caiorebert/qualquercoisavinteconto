package com.imd.qualquercoisa20conto.repository;

import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    @Query(value = "select v from Vendedor v where v.id = :id")
    Vendedor getVendedorById(Long id);

}
