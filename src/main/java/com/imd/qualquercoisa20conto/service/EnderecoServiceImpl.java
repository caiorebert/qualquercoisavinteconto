package com.imd.qualquercoisa20conto.service;

import com.imd.qualquercoisa20conto.interfaces.EnderecoService;
import com.imd.qualquercoisa20conto.model.Endereco;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;
    @Override
    public List<Endereco> getEnderecosByUsuario(Usuario usuario) {
        return enderecoRepository.getEnderecosByIdUsuario(usuario);
    }

    @Override
    public Endereco getEnderecoById(Long id) {
        return enderecoRepository.getEnderecoById(id);
    }

    @Override
    public void salvar(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    @Override
    public void safeDelete(Endereco endereco) {
        endereco.setDeletedAt(LocalDateTime.now());
        enderecoRepository.save(endereco);
    }
}
