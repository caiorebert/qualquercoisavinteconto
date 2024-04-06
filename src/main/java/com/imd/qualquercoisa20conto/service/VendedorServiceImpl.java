package com.imd.qualquercoisa20conto.service;

import com.imd.qualquercoisa20conto.interfaces.VendedorService;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.model.Vendedor;
import com.imd.qualquercoisa20conto.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    VendedorRepository vendedorRepository;

    @Override
    public void salvar(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    @Override
    public Vendedor getVendedorById(Long id) {
        return vendedorRepository.getVendedorById(id);
    }

    @Override
    public void safeDeleteById(Long id) {
        vendedorRepository.safeDeleteById(id, LocalDateTime.now());
    }
}
