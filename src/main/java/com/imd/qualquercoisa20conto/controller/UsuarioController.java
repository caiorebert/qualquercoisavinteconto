package com.imd.qualquercoisa20conto.controller;

import com.imd.qualquercoisa20conto.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.imd.qualquercoisa20conto.interfaces.ProdutoService;
import com.imd.qualquercoisa20conto.interfaces.UsuarioService;
import com.imd.qualquercoisa20conto.interfaces.VendedorService;
import com.imd.qualquercoisa20conto.model.Endereco;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.model.Vendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    @Qualifier("usuarioServiceImpl")
    UsuarioService usuarioService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    VendedorService vendedorService;


    @PostMapping("/logar")
    public String logarUsuario(String email, String senha, Model model){

        Usuario usuario = usuarioService.getUsuarioByEmail(email);

        if (usuario==null) {
            model.addAttribute("errors", "O E-mail informado não existe no sistema.");
            return "redirect:/login";
        }

        if (!usuario.getPassword().equals(senha)) {
            model.addAttribute("errors", "Senha incorreta.");
            return "redirect:/login";
        }

        if(usuario.getVendedor()== null)
        {
            model.addAttribute("usuario",usuario);
            return "redirect:/";
        }

        return "usuario/escolhaLogin";
    }

    @RequestMapping("/novo")
    public String addUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/cadastro";
    }

    @RequestMapping("/edit/{id}")
    public String editUsuario(@PathVariable("id") Long id, Model model){
        Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "usuario/cadastro";
    }

    @RequestMapping("/save")
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario, Model model){
        usuarioService.salvar(usuario);
        model.addAttribute("usuario", usuario);
        return "redirect:/";
    }

    @RequestMapping("/escolhaTipoLogin")
    public String verificaLogado(@ModelAttribute("usuario") Usuario usuario, boolean tipo){
        if (tipo) {
            return "redirect:/";
        } else {
            return "redirect:/vendedor/" + usuario.getVendedor().getId();
        }
    }

}
