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

import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    @Qualifier("enderecoServiceImpl")
    EnderecoService enderecoService;

    @Autowired
    @Qualifier("usuarioServiceImpl")
    UsuarioService usuarioService;

    @RequestMapping("/{usuario_id}/listar")
    public String listarEnderecos(@PathVariable("usuario_id") Long usuario_id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(usuario_id);

        List<Endereco> enderecos = enderecoService.getEnderecosByUsuario(usuario);

        model.addAttribute("usuario", usuario);
        model.addAttribute("enderecos", enderecos);

        return "endereco/index";
    }

    @RequestMapping("/{usuario_id}/novo")
    public String addEndereco(@PathVariable("usuario_id") Long usuario_id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(usuario_id);

        Endereco endereco = new Endereco();

        model.addAttribute("usuario", usuario);
        model.addAttribute("endereco", endereco);

        return "endereco/cadastro";
    }

    @RequestMapping("/editar/{id}")
    public String editEndereco(@PathVariable("id") Long id, Model model) {

        Endereco endereco = enderecoService.getEnderecoById(id);
        Usuario usuario = endereco.getUsuario();
        model.addAttribute("usuario", usuario);
        model.addAttribute("endereco", endereco);

        return "endereco/cadastro";
    }

    @RequestMapping("/{usuario_id}/save")
    public String saveEndereco(@PathVariable Long usuario_id, @ModelAttribute("endereco") Endereco endereco, RedirectAttributes redirectAttributes) {

            Usuario usuario = usuarioService.getUsuarioById(usuario_id);

            endereco.setUsuario(usuario);

            Set<Endereco> lista_Enderecos = usuario.getEndereco();
            lista_Enderecos.add(endereco);
            usuario.setEndereco(lista_Enderecos);
    
            enderecoService.salvar(endereco);

            Vendedor vendedor = usuario.getVendedor();
            
            redirectAttributes.addAttribute("usuario",usuario);
            redirectAttributes.addAttribute("vendedor", vendedor);

            return "redirect:/";
      }

    @RequestMapping("/deletar/{id}")
    public String deletarEndereco(@PathVariable("id") Long id, @ModelAttribute("endereco") Endereco endereco, Model model) {

        Usuario usuario = usuarioService.getUsuarioById(id);

        enderecoService.safeDelete(endereco);

        model.addAttribute("usuario", usuario);

        return "redirect:/" + usuario.getId().toString() + "/listar";
    }

}
