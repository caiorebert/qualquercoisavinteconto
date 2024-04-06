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


@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    EnderecoService enderecoService;

    UsuarioService usuarioService;

    @RequestMapping("/cadastraEndereco")
    public String addEndereco(@ModelAttribute("usuario") Usuario usuario, Model model) {

        Endereco endereco = new Endereco();
        model.addAttribute("endereco", endereco);

        return "endereco/cadastro";
    }

    @RequestMapping("/enderecoCadastrado")
    public String cadastrarEndereco(@ModelAttribute("endereco") Endereco endereco, Model model) {
        
         // Obtém o email do usuário atualmente logado
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         String email = authentication.getName();
         
         // Obtém o usuário com base no email
         Usuario usuario = usuarioService.getUsuarioByEmail(email);
         
         // Associa o novo endereço ao usuário
         endereco.setUsuario(usuario);
         
         // Salva o endereço no banco de dados
         usuario.setEndereco(endereco);

         model.addAttribute("usuario", usuario);
         
         return "usuario/homepage";
    }

}
