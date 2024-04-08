package com.imd.qualquercoisa20conto.service;

import com.imd.qualquercoisa20conto.interfaces.CompraService;
import com.imd.qualquercoisa20conto.model.Compra;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CompraServiceImpl implements CompraService {

    @Autowired
    CompraRepository compraRepository;
    @Override
    public List<Compra> getComprasByUsuario(Usuario usuario) {
        return compraRepository.getComprasByIdUsuario(usuario);
    }

    @Override
    public Compra getCompraById(Long id) {
        return compraRepository.getCompraById(id);
    }

    @Override
    public void salvar(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public void safeDelete(Compra compra) {
        compra.setDeletedAt(LocalDateTime.now());
        compraRepository.save(compra);
    }
}
