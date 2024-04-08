package com.imd.qualquercoisa20conto.service;

import com.imd.qualquercoisa20conto.interfaces.UsuarioService;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void safeDelete(Usuario usuario) {
        usuario.setDeletedAt(LocalDateTime.now());
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.getUsuarioById(id);
    }

    @Override
    public Usuario getUsuarioByEmail(String email) {
        return usuarioRepository.getUsuarioByEmail(email);
    }
}
