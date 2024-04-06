package com.imd.qualquercoisa20conto.service;

import com.imd.qualquercoisa20conto.interfaces.VendedorService;
import com.imd.qualquercoisa20conto.model.Usuario;
import com.imd.qualquercoisa20conto.model.Vendedor;
import com.imd.qualquercoisa20conto.repository.VendedorRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VendedorServiceImpl implements VendedorService {

    VendedorRepository vendedorRepository;

    @Override
    public Vendedor getVendedorById(Long id) {
        return vendedorRepository.getVendedorById(id);
    }

    @Override
    public void safeDeleteById(Long id) {
        vendedorRepository.safeDeleteById(id, LocalDateTime.now());
    }
}
