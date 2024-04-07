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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/vendedor")
public class VendedorController {


    @Autowired
    @Qualifier("vendedorServiceImpl")
    VendedorService vendedorService;

    @Autowired
    @Qualifier("produtoServiceImpl")
    ProdutoService produtoService;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/{usuario_id}/novo")
    public String addVendedor(@PathVariable("usuario_id") Long usuario_id, Model model) {

        Usuario usuario = usuarioService.getUsuarioById(usuario_id);
        Vendedor vendedor = new Vendedor();

        usuario.setVendedor(vendedor);
        vendedor.setUsuario(usuario);

        model.addAttribute("usuario", usuario);
        model.addAttribute("vendedor", vendedor);

        return "vendedor/cadastro";
    }

    @RequestMapping("/edit/{id}")
    public String editVendedor(@PathVariable("id") Long id, Model model) {

        Vendedor vendedor = vendedorService.getVendedorById(id);

        model.addAttribute("usuario", vendedor.getUsuario());
        model.addAttribute("vendedor", vendedor);

        return "vendedor/cadastro";
    }

    @RequestMapping("/save")
    public String saveVendedor(@ModelAttribute("vendedor") Vendedor vendedor,
                               Model model,
                               RedirectAttributes redirectAttributes) {
        vendedorService.salvar(vendedor);
        redirectAttributes.addAttribute("vendedor", vendedor);
        return "redirect:/vendedor/" + vendedor.getId();
    }

    @RequestMapping("/{id}")
    public String vendedorCadastrado(@PathVariable("id") Long id, Model model) {
        Vendedor vendedor = vendedorService.getVendedorById(id);
        List<Produto> produtos = produtoService.getProdutosByVendedor(vendedor);

        model.addAttribute("vendedor", vendedor);
        model.addAttribute("produtos", produtos);

        return "vendedor/index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteVendedor(@PathVariable("id") Long id, Model model) {
        vendedorService.safeDeleteById(id);
        return "vendedor/index";
    }
}
