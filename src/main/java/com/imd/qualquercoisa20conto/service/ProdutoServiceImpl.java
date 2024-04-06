package com.imd.qualquercoisa20conto.service;

import com.imd.qualquercoisa20conto.interfaces.ProdutoService;
import com.imd.qualquercoisa20conto.model.Produto;
import com.imd.qualquercoisa20conto.model.Vendedor;
import com.imd.qualquercoisa20conto.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ProdutoServiceImpl implements ProdutoService {

    ProdutoRepository produtoRepository;

    @Override
    public void salvar(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public void safeDeleteById(Long id) {
        produtoRepository.safeDeleteById(id, LocalDateTime.now());
    }

    @Override
    public List<Produto> getAllProdutos() {
        return produtoRepository.getAllProdutos();
    }

    @Override
    public List<Produto> getProdutosByVendedor(Vendedor vendedor) {
        return produtoRepository.getProdutosByVendedor(vendedor);
    }
}
