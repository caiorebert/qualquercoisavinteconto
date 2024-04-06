package com.imd.qualquercoisa20conto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imd.qualquercoisa20conto.interfaces.EnderecoService;
import com.imd.qualquercoisa20conto.interfaces.ProdutoService;
import com.imd.qualquercoisa20conto.interfaces.UsuarioService;
import com.imd.qualquercoisa20conto.model.Endereco;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.model.Vendedor;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    @Qualifier("enderecoServiceImpl")
    EnderecoService enderecoService;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/cadastraEndereco/{id}")
    public String addEndereco(@PathVariable("id") Long id, Model model) {

        Usuario usuario = usuarioService.findUsuarioById(id);

        Endereco endereco = new Endereco();
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("endereco", endereco);

        return "endereco/cadastro";
    }

    @RequestMapping("/enderecoCadastrado/{id}")
    public String cadastrarEndereco(@PathVariable("id") Long id, @ModelAttribute("endereco") Endereco endereco, Model model) {
        
        Usuario usuario = usuarioService.findUsuarioById(id);
       
         enderecoService.salvar(endereco);


         model.addAttribute("usuario", usuario);
         
         return "usuario/homepage";
    }

}
