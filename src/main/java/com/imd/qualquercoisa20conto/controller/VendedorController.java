package com.imd.qualquercoisa20conto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imd.qualquercoisa20conto.interfaces.EnderecoService;
import com.imd.qualquercoisa20conto.interfaces.ProdutoService;
import com.imd.qualquercoisa20conto.interfaces.UsuarioService;
import com.imd.qualquercoisa20conto.interfaces.VendedorService;
import com.imd.qualquercoisa20conto.model.Endereco;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.model.Vendedor;
import com.imd.qualquercoisa20conto.model.Produto;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/vendedor")
public class VendedorController {


    @Autowired
    @Qualifier("vendedorServiceImpl")
    VendedorService vendedorService;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/cadastraVendedor/{id}")
    public String addVendedor(@PathVariable("id") Long id, Model model) {

        Usuario usuario = usuarioService.getUsuarioById(id);

        Vendedor vendedor = new Vendedor();

        model.addAttribute("usuario", usuario);
        model.addAttribute("vendedor", vendedor);

        return "vendedor/cadastro";
    }

    @RequestMapping("/vendedorCadastrado/{vendedor}")
    public String vendedorCadastrado(@PathVariable("vendedor") Vendedor vendedor, Model model) {
        
        
        model.addAttribute("vendedor", vendedor);

        return "vendedor/homepage";


    }
    

}
