package com.imd.qualquercoisa20conto.repository;

import com.imd.qualquercoisa20conto.model.Produto;
import com.imd.qualquercoisa20conto.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(value = "select p from Produto p where p.vendedor = :vendedor")
    List<Produto> getProdutosByVendedor(Vendedor vendedor);

    List<Produto> getAllProdutos();

    @Query(value = "select p from Produto p where p.nome = :nome")
    List<Produto> getProdutosByNome(String nome);

    @Query(value = "select p from Produto p where p.preco = :preco")
    List<Produto> getProdutosByPreco(float preco);

    @Query(value = "select p from Produto p where :precoMax <= p.preco AND p.preco >= :precoMin")
    List<Produto> getProdutosByPrecoMinPrecoMax(float precoMin, float precoMax);

    @Query(value = "UPDATE Produto p SET p.deletedAt = :timestamp where p.id = :id")
    void safeDeleteById(Long id, LocalDateTime timestamp);
}
