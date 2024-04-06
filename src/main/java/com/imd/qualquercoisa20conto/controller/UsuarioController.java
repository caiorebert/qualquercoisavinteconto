package com.imd.qualquercoisa20conto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imd.qualquercoisa20conto.interfaces.ProdutoService;
import com.imd.qualquercoisa20conto.interfaces.UsuarioService;
import com.imd.qualquercoisa20conto.model.Endereco;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.model.Vendedor;

import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioService usuarioService;
    ProdutoService produtoService;

    //direciona pra o formulario de cadastro do usuario
    @RequestMapping("/cadastrarUsuario")
    public String cadastrarUsuario(Model model){

        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);

        return "usuario/cadastro";
    }

    //cadastrou o usuario e direciona pra pagina de login
    @RequestMapping("/usuarioCadastrado")
    public String addUsuario(@ModelAttribute("usuario") Usuario usuario,  
    Model model){

        usuarioService.salvar(usuario);

        return "home/";
    }

    //ao tentar fazer login, verifica se o usuario e senha existem
    //se o usuario tiver cadastro de vendedor, vai pra uma pagina de escolha, senao vai pra homepage de usuario
    @RequestMapping("/usuarioLogin")
    public String Login(@ModelAttribute("email") String email,  @ModelAttribute("senha") String senha,
    Model model){
 
        Usuario usuario = usuarioService.getUsuarioByEmail(email);

        if(usuario != null)
        {
            if(usuario.getVendedor()!= null)
            {
                model.addAttribute("usuario",usuario);
                return "usuario/escolhaTipo";
            }
            else
            {
                model.addAttribute("usuario",usuario);
                return "usuario/homepage";
            }
        }
        else
        {
            return "redirect:home/";
        }
        
 
    }

    //caso o usuario tenha cadastro de vendedor, recebe resposta do form, na variavel tipo, pra saber se o usuario quer continuar como Cliente ou como Vendedor
    @RequestMapping("/escolhaTipoLogin")
    public String verificaLogado(@ModelAttribute("usuario") Usuario usuario, @ModelAttribute("tipo") String tipo,
    Model model){

            if (tipo.equals("Cliente")) {
                model.addAttribute("usuario",usuario);
                return "usuario/homepage";
            } else {
                return "vendedor/homepage";
            }

    }

}
