package com.imd.qualquercoisa20conto.controller;

import com.imd.qualquercoisa20conto.model.Vendedor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.imd.qualquercoisa20conto.interfaces.ProdutoService;
import com.imd.qualquercoisa20conto.interfaces.UsuarioService;
import com.imd.qualquercoisa20conto.interfaces.VendedorService;
import com.imd.qualquercoisa20conto.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    public String logarUsuario(String email, String password, Model model, RedirectAttributes redirectAttributes){

        Usuario usuario = usuarioService.getUsuarioByEmail(email);

        if (usuario==null) {
            model.addAttribute("errors", "O E-mail informado não existe no sistema.");
            return "redirect:/login";
        }

        if (!usuario.getPassword().equals(password)) {
            model.addAttribute("errors", "Senha incorreta.");
            return "redirect:/login";
        }


        if(usuario.getVendedor()== null)
        {
            redirectAttributes.addAttribute("usuario",usuario);
            redirectAttributes.addAttribute("vendedor", null);
            return "redirect:/";
        }

        model.addAttribute("usuario",usuario);
        model.addAttribute("vendedor", vendedorService.getVendedorById(usuario.getVendedor().getId()));

        return "usuario/escolhaLogin";
    }

    @RequestMapping("/redirectHome/{id}")
    public String getUsuario(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        Usuario usuario = usuarioService.getUsuarioById(id);
        redirectAttributes.addAttribute("usuario", usuario);
        return "redirect:/";
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
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario, Model model, RedirectAttributes requestAttribute){
        usuarioService.salvar(usuario);
        requestAttribute.addAttribute("usuario", usuario);
        return "redirect:/";
    }

    @RequestMapping("/escolhaTipoLogin")
    public String verificaLogado(@RequestParam("usuario") Usuario usuario,
                                 @RequestParam("vendedor") Vendedor vendedor,
                                 boolean tipo,
                                 Model model){
        model.addAttribute("usuario", usuario);

        if (vendedor!=null) {
            model.addAttribute("vendedor", vendedor);
            return "redirect:/vendedor/" + usuario.getVendedor().getId();
        }

        return "redirect:/";
    }

    @RequestMapping("/deslogar")
    public String verificaLogado(){
        return "redirect:/";
    }

}
