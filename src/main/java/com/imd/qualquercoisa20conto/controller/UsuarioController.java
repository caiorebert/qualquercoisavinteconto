package com.imd.qualquercoisa20conto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imd.qualquercoisa20conto.interfaces.UsuarioService;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.model.Vendedor;

import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioService usuarioService;

    //direciona pra o formulario de cadastro do usuario
    @RequestMapping("/cadastrarUsuario")
    public String cadastrarUsuario(Model model){

        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);

        return "usuario/cadastro";
    }

    //direciona pra pagina de login
    @RequestMapping("/usuarioCadastrado")
    public String addUsuario(@ModelAttribute("usuario") Usuario usuario,  
    Model model){

        usuarioService.salvar(usuario);

        return "home/";
    }

    //direciona pra pagina que verifica se o usuario e senha existem
    @RequestMapping("/usuarioLogin")
    public String Login(@ModelAttribute("email") String email,  @ModelAttribute("senha") String senha,
    Model model){
 
        Usuario usuario = usuarioRepository.findUsuario(email, senha);

        if(usuario != null)
        {
            model.addAttribute("usuario",usuario);
            return "usuario/logado";
        }
        else
        {
            return "redirect:home/";
        }
        
 
    }

    //se o usuario tiver cadastro de vendedor, vai pra uma pagina de escolha, senao vai pra homepage de usuario
    @RequestMapping("/usuarioLogado")
    public String logado(@ModelAttribute("usuario") Usuario usuario,
    Model model){
 
        if(usuario.getVendedor()!= null)
        {
            model.addAttribute("usuario",usuario);
            return "usuario/escolhaTipo";
        }
        else
        {
            return "usuario/homepage";
        }
 
    }

    //recebe resposta do form pra saber se o usuario quer continuar como Cliente ou como Vendedor
    @RequestMapping("/escolhaTipoLogin")
    public String verificaLogado(@ModelAttribute("usuario") Usuario usuario, @ModelAttribute("tipo") String tipo,
    Model model){

            if (tipo.equals("Cliente")) {
                return "usuario/homepage";
            } else {
                return "vendedor/homepage";
            }

    }

}
