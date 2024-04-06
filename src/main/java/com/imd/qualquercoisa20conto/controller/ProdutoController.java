package com.imd.qualquercoisa20conto.controller;

import com.imd.qualquercoisa20conto.interfaces.ProdutoService;
import com.imd.qualquercoisa20conto.interfaces.VendedorService;
import com.imd.qualquercoisa20conto.model.Produto;
import com.imd.qualquercoisa20conto.model.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    @Qualifier("produtoServiceImpl")
    ProdutoService produtoService;

    @Autowired
    @Qualifier("vendedorServiceImpl")
    VendedorService vendedorService;

    @RequestMapping("/listar")
    public String getProdutos(Model model){
        List<Produto> produtos = produtoService.getAllProdutos();
        model.addAttribute("produtos", produtos);
        return "produto/listar";
    }

    @RequestMapping("/filtrar")
    public String getProdutosFiltrar(Model model){
        List<Produto> produtos = produtoService.getAllProdutos();
        model.addAttribute("produtos", produtos);
        return "produto/listar";
    }

    @RequestMapping("/{vendedor_id}/novo")
    public String adicionarProduto(@PathVariable Long vendedor_id, Model model){
        Vendedor vendedor = vendedorService.getVendedorById(vendedor_id);
        model.addAttribute("produto", new Produto());
        model.addAttribute("vendedor", vendedor);
        return "produto/cadastrar";
    }

    @RequestMapping("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model){
        Produto produto = produtoService.getProdutoById(id);
        model.addAttribute("produto", produto);
        return "produto/cadastrar";
    }

    @RequestMapping("/save")
    public String editarProduto(@ModelAttribute("produto") Produto produto, Model model){
        produtoService.salvar(produto);
        model.addAttribute("produto", produto);
        return "produto/cadastrar";
    }

    @RequestMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable("id") Long id){
        produtoService.safeDeleteById(id);
        return "redirect:/produto/listar";
    }
}
