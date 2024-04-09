package com.imd.qualquercoisa20conto.controller;

import com.imd.qualquercoisa20conto.interfaces.CompraService;
import com.imd.qualquercoisa20conto.interfaces.ProdutoService;
import com.imd.qualquercoisa20conto.interfaces.UsuarioService;
import com.imd.qualquercoisa20conto.model.Compra;
import com.imd.qualquercoisa20conto.model.Produto;
import com.imd.qualquercoisa20conto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    @Qualifier("compraServiceImpl")
    CompraService compraService;

    @Autowired
    @Qualifier("usuarioServiceImpl")
    UsuarioService usuarioService;

    @Autowired
    @Qualifier("produtoServiceImpl")
    ProdutoService produtoService;

    @RequestMapping("/{usuario_id}/listar")
    public String listar(@PathVariable("usuario_id") Long id, Model model){
        Usuario usuario = usuarioService.getUsuarioById(id);
        List<Compra> compras = compraService.getComprasByUsuario(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("compras", compras);
        return "compra/index";
    }

    @RequestMapping("/{usuario_id}/novo/{produto_id}")
    public String novaCompra(@PathVariable("usuario_id") Long usuario_id,
                             @PathVariable("produto_id") Long produto_id,
                             Model model){
        Produto produto = produtoService.getProdutoById(produto_id);
        Usuario usuario = usuarioService.getUsuarioById(usuario_id);

        if (produto.getQuantidade() == 0) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("produtoEsgotado", true);
        } else {
            model.addAttribute("produtoEsgotado", false);

            Compra compra = new Compra();
            compra.setProduto(produto);
            compra.setUsuario(usuario);

            model.addAttribute("produto", produto);
            model.addAttribute("usuario", usuario);
            model.addAttribute("compra", compra);
        }
        return "compra/confirmar";
    }

    @RequestMapping("/save")
    public String comprar(@ModelAttribute("compra") Compra compra){
        Produto produto = compra.getProduto();
        produto.setQuantidade(produto.getQuantidade() - 1);
        produtoService.salvar(produto);
        compraService.salvar(compra);
        return "redirect:/compra/" + compra.getUsuario().getId() + "/novo/" + produto.getId();
    }
}
