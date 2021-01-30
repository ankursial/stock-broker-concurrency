package com.ankur.stockbroker.services;

import com.ankur.stockbroker.models.Stock;
import java.util.Optional;

public interface IStockService {

  Optional<Stock> findBySymbol(String symbol);
}
