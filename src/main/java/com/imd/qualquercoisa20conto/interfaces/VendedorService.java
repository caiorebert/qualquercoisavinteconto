package com.imd.qualquercoisa20conto.interfaces;

import com.imd.qualquercoisa20conto.model.Vendedor;

public interface VendedorService {

    public Vendedor getVendedorById(Long id);

    public void safeDeleteById(Long id);
}
