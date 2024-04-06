package com.imd.qualquercoisa20conto.interfaces;

import com.imd.qualquercoisa20conto.model.Endereco;
import com.imd.qualquercoisa20conto.model.Usuario;

public interface EnderecoService {

    public void salvar(Endereco endereco);

    public void safeDeleteById(Long id);

    public Endereco getEnderecoByUsuario(Usuario usuario);


}
