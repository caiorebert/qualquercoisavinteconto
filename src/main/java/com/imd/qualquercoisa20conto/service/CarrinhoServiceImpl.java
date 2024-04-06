package com.imd.qualquercoisa20conto.service;

import com.imd.qualquercoisa20conto.interfaces.CarrinhoService;
import com.imd.qualquercoisa20conto.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    CarrinhoRepository carrinhoRepository;
}
