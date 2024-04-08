package com.imd.qualquercoisa20conto.interfaces;

import com.imd.qualquercoisa20conto.model.Usuario;

public interface UsuarioService {

    public void salvar(Usuario usuario);

    public void safeDelete(Usuario usuario);

    public Usuario getUsuarioById(Long id);

    public Usuario getUsuarioByEmail(String email);
}
