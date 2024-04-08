package com.imd.qualquercoisa20conto.interfaces;

import com.imd.qualquercoisa20conto.model.Produto;
import com.imd.qualquercoisa20conto.model.Vendedor;

import java.util.List;

public interface ProdutoService {

    public void salvar(Produto produto);

    public void safeDelete(Produto produto);

    public Produto getProdutoById(Long id);

    public List<Produto> getAllProdutos();

    public List<Produto> getProdutosByVendedor(Vendedor vendedor);
}
