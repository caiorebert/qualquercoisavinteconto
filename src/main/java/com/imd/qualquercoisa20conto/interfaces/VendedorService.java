package com.imd.qualquercoisa20conto.interfaces;

import com.imd.qualquercoisa20conto.model.Vendedor;

public interface VendedorService {

    public void salvar(Vendedor vendedor);

    public Vendedor getVendedorById(Long id);

    public void safeDeleteById(Long id);
}
