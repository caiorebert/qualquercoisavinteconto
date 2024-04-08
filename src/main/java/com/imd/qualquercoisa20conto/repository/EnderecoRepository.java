package com.imd.qualquercoisa20conto.repository;

import com.imd.qualquercoisa20conto.model.Endereco;
import com.imd.qualquercoisa20conto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query(value = "select e from Endereco e where e.id = :id")
    Endereco getEnderecoById(Long id);

    @Query(value = "select e from Endereco e where e.usuario = :usuario")
    List<Endereco> getEnderecosByIdUsuario(Usuario usuario);

}
