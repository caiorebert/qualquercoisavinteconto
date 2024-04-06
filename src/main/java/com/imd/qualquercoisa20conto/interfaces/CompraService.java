package com.imd.qualquercoisa20conto.interfaces;

import com.imd.qualquercoisa20conto.model.Compra;
import com.imd.qualquercoisa20conto.model.Usuario;

import java.util.List;

public interface CompraService {

    public Compra getCompraById(Long id);

    public void salvar(Compra compra);

    public void safeDeleteById(Long id);

    public List<Compra> getComprasByUsuario(Usuario usuario);


}
