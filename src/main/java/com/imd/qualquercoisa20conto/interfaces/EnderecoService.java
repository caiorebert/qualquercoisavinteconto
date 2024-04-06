package com.imd.qualquercoisa20conto.interfaces;

import com.imd.qualquercoisa20conto.model.Endereco;
import com.imd.qualquercoisa20conto.model.Usuario;

import java.util.List;

public interface EnderecoService {

    public Endereco getEnderecoById(Long id);

    public void salvar(Endereco endereco);

    public void safeDeleteById(Long id);

    public List<Endereco> getEnderecosByUsuario(Usuario usuario);


}
