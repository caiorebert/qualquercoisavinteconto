package com.imd.qualquercoisa20conto.service;

import com.imd.qualquercoisa20conto.interfaces.EnderecoService;
import com.imd.qualquercoisa20conto.model.Endereco;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.repository.EnderecoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EnderecoServiceImpl implements EnderecoService {

    EnderecoRepository enderecoRepository;
    @Override
    public Endereco getEnderecoByUsuario(Usuario usuario) {
        return enderecoRepository.getEnderecoByIdUsuario(usuario);
    }

    @Override
    public void salvar(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    @Override
    public void safeDeleteById(Long id) {
        enderecoRepository.safeDeleteById(id, LocalDateTime.now());
    }
}
