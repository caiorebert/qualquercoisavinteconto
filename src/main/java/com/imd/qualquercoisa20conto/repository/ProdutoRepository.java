package com.imd.qualquercoisa20conto.repository;

import com.imd.qualquercoisa20conto.model.Produto;
import com.imd.qualquercoisa20conto.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(value = "select p from Produto p where p.vendedor = :vendedor and p.deletedAt is null")
    List<Produto> getProdutosByVendedor(Vendedor vendedor);

    @Query(value = "select p from Produto p where p.deletedAt is null")
    List<Produto> getAllProdutos();

    @Query(value = "select p from Produto p where p.id = :id and p.deletedAt is null")
    Produto getProdutoById(Long id);

    @Query(value = "select p from Produto p where p.nome = :nome and p.deletedAt is null")
    List<Produto> getProdutosByNome(String nome);

    @Query(value = "select p from Produto p where p.preco = :preco and p.deletedAt is null")
    List<Produto> getProdutosByPreco(float preco);

    @Query(value = "select p from Produto p where :precoMax <= p.preco AND p.preco >= :precoMin and p.deletedAt is null")
    List<Produto> getProdutosByPrecoMinPrecoMax(float precoMin, float precoMax);

}
