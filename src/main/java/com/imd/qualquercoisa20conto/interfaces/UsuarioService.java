package com.imd.qualquercoisa20conto.interfaces;

import com.imd.qualquercoisa20conto.model.Usuario;

public interface UsuarioService {

    public void salvar(Usuario usuario);

    public void safeDeleteById(Long id);

    public Usuario getUsuarioByEmail(String email);
}
