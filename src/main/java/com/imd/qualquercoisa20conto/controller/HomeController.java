package com.imd.qualquercoisa20conto.controller;

import com.imd.qualquercoisa20conto.interfaces.ProdutoService;
import com.imd.qualquercoisa20conto.model.Produto;
import com.imd.qualquercoisa20conto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    @Qualifier("produtoServiceImpl")
    ProdutoService produtoService;

    @RequestMapping("/")
    public String home(@ModelAttribute("usuario") Usuario usuario, Model model){
        if (usuario!=null) {
            model.addAttribute("usuario", usuario);
        }
        List<Produto> produtos = produtoService.getAllProdutos();
        model.addAttribute("produtos", produtos);
        return "home/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "usuario/login";
    }

    @RequestMapping("/cadastro")
    public String cadastro(Model model){

        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);

        return "usuario/cadastro";
    }

}
