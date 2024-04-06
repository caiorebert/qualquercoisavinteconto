package com.imd.qualquercoisa20conto.controller;

import com.imd.qualquercoisa20conto.interfaces.CompraService;
import com.imd.qualquercoisa20conto.interfaces.UsuarioService;
import com.imd.qualquercoisa20conto.model.Compra;
import com.imd.qualquercoisa20conto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    @Qualifier("compraServiceImpl")
    CompraService compraService;

    @Autowired
    @Qualifier("usuarioServiceImpl")
    UsuarioService usuarioService;

    @RequestMapping("/{usuario_id}/listar")
    public String listar(@PathVariable("usuario_id") Long id, Model model){
        Usuario usuario = usuarioService.getUsuarioById(id);
        List<Compra> compras = compraService.getComprasByUsuario(usuario);
        model.addAttribute("compras", compras);
        return "compra/index";
    }

    @RequestMapping("/save")
    public String comprar(@ModelAttribute("compra") Compra compra){
        compraService.salvar(compra);
        return "redirect:/" + compra.getUsuario().getId() + "/listar";
    }
}
