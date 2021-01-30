package com.ankur.stockbroker.services;

import com.ankur.stockbroker.models.Stock;
import com.ankur.stockbroker.repositories.StockRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService implements IStockService {

  @Autowired
  private StockRepository stockRepository;

  @Override
  public Optional<Stock> findBySymbol(String symbol) {
    return stockRepository.findBySymbol(symbol);
  }
}
