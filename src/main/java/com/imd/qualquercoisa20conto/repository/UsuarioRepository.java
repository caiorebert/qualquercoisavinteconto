package com.imd.qualquercoisa20conto.repository;

import com.imd.qualquercoisa20conto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "select u from Usuario u where u.nome like %:nome%")
    Usuario getUsuarioByName(String nome);
}
